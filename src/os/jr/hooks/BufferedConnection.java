package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class BufferedConnection extends GameClass{

	public BufferedConnection() {
		super("fa");
		String bufferedConnection = "fa";
		this.fields.put("BufferedConnection_InputStream", new GameField("d", bufferedConnection));
		this.fields.put("BufferedConnection_OutputStream", new GameField("x", bufferedConnection));
		this.fields.put("BufferedConnection_Socket", new GameField("k", bufferedConnection));
		this.fields.put("BufferedConnection_Payload", new GameField("b", bufferedConnection));
		this.fields.put("BufferedConnection_IsClosed", new GameField("z", bufferedConnection));
	}

}
