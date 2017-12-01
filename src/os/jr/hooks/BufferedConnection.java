package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class BufferedConnection extends GameClass {

	public static final String bufferedConnection = "fl";
	public static final String field_InputStream = "a";
	public static final String field_OutputStream = "w";
	public static final String field_Socket = "e";
	public static final String field_Payload = "t";
	public static final String field_IsClosed = "k";

	public BufferedConnection() {
		super(bufferedConnection);
		this.fields.put("BufferedConnection_InputStream", new GameField(field_InputStream, bufferedConnection));
		this.fields.put("BufferedConnection_OutputStream", new GameField(field_OutputStream, bufferedConnection));
		this.fields.put("BufferedConnection_Socket", new GameField(field_Socket, bufferedConnection));
		this.fields.put("BufferedConnection_Payload", new GameField(field_Payload, bufferedConnection));
		this.fields.put("BufferedConnection_IsClosed", new GameField(field_IsClosed, bufferedConnection));
	}

}
