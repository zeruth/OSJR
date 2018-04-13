package discord;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * Rpc connection implementation
 */
public class RpcConnection {
	/**
	 * Connect Callback interface
	 */
	public interface ConnectCallback {
		void accept();
	}

	/**
	 * Disconnect Callback interface
	 */
	public interface DisconnectCallback {
		void accept(ErrorCode lastErrorCode, String lastErrorMessage);
	}

	private class MessageFrame // I know this class is quite ugly yeah... will find a better way to handle that
	{
		byte[] headerBuffer;
		int length;

		String message;
		byte[] messageBuffer;
		OpCode opCode;

		MessageFrame() {
			this.headerBuffer = new byte[8];
			this.messageBuffer = new byte[65535 - this.headerBuffer.length];
		}

		boolean parseHeader() {
			try {
				ByteArrayInputStream inputStream = new ByteArrayInputStream(this.headerBuffer);

				this.opCode = OpCode.values()[this.readInt(inputStream)];
				this.length = this.readInt(inputStream);

				return true;
			} catch (Exception ignored) {
				ignored.printStackTrace();
				return false;
			}
		}

		boolean parseMessage() {
			this.message = new String(Arrays.copyOfRange(this.messageBuffer, 0, this.length));

			return true;
		}

		private int readInt(InputStream inputStream) throws IOException {
			int ch1 = inputStream.read();
			int ch2 = inputStream.read();
			int ch3 = inputStream.read();
			int ch4 = inputStream.read();
			if ((ch1 | ch2 | ch3 | ch4) < 0)
				throw new EOFException();

			return ((ch4 << 24) + (ch3 << 16) + (ch2 << 8) + ch1);
		}

		boolean write() {
			try {
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

				this.messageBuffer = this.message.getBytes();

				this.writeInt(this.opCode.getId(), byteArrayOutputStream);
				this.writeInt(this.length = this.messageBuffer.length, byteArrayOutputStream);

				this.headerBuffer = byteArrayOutputStream.toByteArray();

				return true;
			} catch (Exception ignored) {
				return false;
			}
		}

		private void writeInt(int v, OutputStream outputStream) throws IOException {
			outputStream.write(v & 0xFF);
			outputStream.write((v >>> 8) & 0xFF);
			outputStream.write((v >>> 16) & 0xFF);
			outputStream.write((v >>> 24) & 0xFF);
		}
	}

	private enum OpCode {
		CLOSE(2), FRAME(1), HANDSHAKE(0), PING(3), PONG(4);

		private final int id;

		OpCode(int id) {
			this.id = id;
		}

		public int getId() {
			return this.id;
		}
	}

	private enum State {
		// AWAITING_RESPONSE, FIXME Not used ?
		// https://github.com/discordapp/discord-rpc/search?utf8=%E2%9C%93&q=AwaitingResponse&type=
		CONNECTED, DISCONNECTED, SENT_HANDSHAKE
	}

	private static final Gson GSON = new GsonBuilder().create();

	/**
	 * Create a RPC connection
	 *
	 * @param applicationId
	 *            Application ID
	 * @return New RPC connection
	 */
	public static RpcConnection create(String applicationId) {
		return new RpcConnection(applicationId);
	}

	/**
	 * Destroy a RPC connection
	 *
	 * @param rpcConnection
	 *            The connection to destroy
	 */
	public static void destroy(RpcConnection rpcConnection) {
		rpcConnection.close();
	}

	private final String appId;

	private BaseConnection baseConnection;

	private ConnectCallback connectCallback;

	private DisconnectCallback disconnectCallback;

	private ErrorCode lastErrorCode;

	private String lastErrorMessage;

	private State state;

	private final Lock writeLock;

	private RpcConnection(String applicationId) {
		this.baseConnection = BaseConnection.create();
		this.state = State.DISCONNECTED;

		this.connectCallback = null;
		this.disconnectCallback = null;

		this.appId = applicationId;
		this.lastErrorCode = ErrorCode.SUCCESS;
		this.lastErrorMessage = null;

		this.writeLock = new ReentrantLock();
	}

	private void close() {
		if (this.disconnectCallback != null && (this.state == State.CONNECTED || this.state == State.SENT_HANDSHAKE))
			this.disconnectCallback.accept(this.lastErrorCode, this.lastErrorMessage);

		BaseConnection.destroy(this.baseConnection);
		this.state = State.DISCONNECTED;
	}

	/**
	 * Get the base connection implementation
	 *
	 * @return Used connection
	 */
	public BaseConnection getBaseConnection() {
		return this.baseConnection;
	}

	/**
	 * Get if this connection is opened and connected to Discord
	 *
	 * @return If connected
	 */
	public boolean isOpen() {
		return this.state == State.CONNECTED;
	}

	/**
	 * Open the connection to Discord
	 */
	public void open() {
		if (this.state == State.CONNECTED)
			return;

		if (this.state == State.DISCONNECTED && !this.baseConnection.open())
			return;

		if (this.state == State.SENT_HANDSHAKE) {
			JsonObject message = new JsonObject();
			if (this.read(message, true)) {
				String cmd = message.has("cmd") && !message.get("cmd").isJsonNull() ? message.get("cmd").getAsString()
						: null;
				String evt = message.has("evt") && !message.get("evt").isJsonNull() ? message.get("evt").getAsString()
						: null;

				if (cmd != null && evt != null && cmd.equals("DISPATCH") && evt.equals("READY")) {
					this.state = State.CONNECTED;

					if (this.connectCallback != null)
						this.connectCallback.accept();
				}
			}
		} else {
			MessageFrame messageFrame = new MessageFrame();

			messageFrame.opCode = OpCode.HANDSHAKE;
			messageFrame.message = this.writeHandShakeObj();

			boolean success;

			this.writeLock.lock();

			try {
				success = messageFrame.write()
						&& this.baseConnection.write(messageFrame.headerBuffer, messageFrame.headerBuffer.length)
						&& this.baseConnection.write(messageFrame.messageBuffer, messageFrame.length);
			} finally {
				this.writeLock.unlock();
			}

			if (success)
				this.state = State.SENT_HANDSHAKE;
			else
				this.close();
		}
	}

	/**
	 * Read data from RPC connection
	 *
	 * @param jsonObject
	 *            JsonObject to put the results
	 * @param wait
	 *            If the read should be blocking Note : if a header has been
	 *            received, the following data will be read using a blocking call
	 * @return {@code true} if data has been received
	 */
	public boolean read(JsonObject jsonObject, boolean wait) {
		if (this.state != State.CONNECTED && this.state != State.SENT_HANDSHAKE)
			return false;

		MessageFrame messageFrame = new MessageFrame();

		while (true) {
			boolean didRead = this.baseConnection.read(messageFrame.headerBuffer, messageFrame.headerBuffer.length,
					wait);

			if (!didRead || !messageFrame.parseHeader()) {
				if (!this.baseConnection.isOpen()) {
					this.lastErrorCode = ErrorCode.PIPE_CLOSED;
					this.lastErrorMessage = "Pipe closed";
					this.close();
				}

				return false;
			}

			if (messageFrame.length > 0) {
				didRead = this.baseConnection.read(messageFrame.messageBuffer, messageFrame.length, true);

				if (!didRead || !messageFrame.parseMessage()) {
					this.lastErrorCode = ErrorCode.READ_CORRUPT;
					this.lastErrorMessage = "Partial dada in frame";
					this.close();

					return false;
				}
			}

			switch (messageFrame.opCode) {
			case CLOSE:
				JsonObject object = RpcConnection.GSON.fromJson(messageFrame.message, JsonObject.class);
				object.entrySet().forEach(entry -> jsonObject.add(entry.getKey(), entry.getValue()));

				int error = object.has("code") && !object.get("code").isJsonNull() ? object.get("code").getAsInt() : 0;
				this.lastErrorCode = error >= ErrorCode.values().length ? ErrorCode.UNKNOWN : ErrorCode.values()[error];
				this.lastErrorMessage = object.has("message") && !object.get("message").isJsonNull()
						? object.get("message").getAsString()
						: "";
				this.close();
				return false;

			case FRAME:
				object = RpcConnection.GSON.fromJson(messageFrame.message, JsonObject.class);
				object.entrySet().forEach(entry -> jsonObject.add(entry.getKey(), entry.getValue()));
				return true;

			case PING:
				messageFrame.opCode = OpCode.PONG;

				boolean success;

				this.writeLock.lock();

				try {
					success = !this.baseConnection.write(messageFrame.headerBuffer, messageFrame.headerBuffer.length)
							|| !this.baseConnection.write(messageFrame.messageBuffer, messageFrame.length);
				} finally {
					this.writeLock.unlock();
				}

				if (success)
					this.close();

				break;

			case PONG:
				break;

			case HANDSHAKE:
			default:
				this.lastErrorCode = ErrorCode.READ_CORRUPT;
				this.lastErrorMessage = "Bad ipc frame";
				this.close();
				return false;
			}
		}
	}

	/**
	 * Set connect callback
	 *
	 * @param connectCallback
	 *            Callback implementation
	 */
	public void setConnectCallback(ConnectCallback connectCallback) {
		this.connectCallback = connectCallback;
	}

	/**
	 * Set disconnect callback
	 *
	 * @param disconnectCallback
	 *            Callback implementation
	 */
	public void setDisconnectCallback(DisconnectCallback disconnectCallback) {
		this.disconnectCallback = disconnectCallback;
	}

	/**
	 * Write data to RPC connection Header is automatically set to FRAME
	 *
	 * @param bytes
	 *            Data to send
	 * @return {@code true} if the data has been sent
	 */
	public boolean write(byte[] bytes) {
		MessageFrame messageFrame = new MessageFrame();
		messageFrame.opCode = OpCode.FRAME;
		messageFrame.message = new String(bytes);

		boolean success;
		this.writeLock.lock();

		try {
			success = !messageFrame.write()
					|| !this.baseConnection.write(messageFrame.headerBuffer, messageFrame.headerBuffer.length)
					|| !this.baseConnection.write(messageFrame.messageBuffer, messageFrame.length);
		} finally {
			this.writeLock.unlock();
		}

		if (!success) {
			this.close();
			return false;
		}

		return true;
	}

	private String writeHandShakeObj() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("v", new JsonPrimitive(1));
		jsonObject.add("client_id", new JsonPrimitive(this.appId));

		return jsonObject.toString();
	}
}
