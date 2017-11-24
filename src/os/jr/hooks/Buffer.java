package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Buffer extends GameClass{

	public Buffer() {
		super("fr");
		String buffer = "fr";
		this.fields.put("Buffer_Payload", new GameField("d", buffer));
		this.fields.put("Buffer_CRC", new GameField("k", buffer));
	}
}
