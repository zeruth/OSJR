package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Buffer extends GameClass {

	public static final String buffer = "gh";
	public static final String field_Payload = "a";
	public static final String field_CRC = "e";

	public Buffer() {
		super(buffer);
		this.fields.put("Buffer_Payload", new GameField(field_Payload, buffer));
		this.fields.put("Buffer_CRC", new GameField(field_CRC, buffer));
	}
}
