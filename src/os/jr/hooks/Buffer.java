package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class Buffer extends GameClass{
	
	public static final String crc32Table = "crc32Table";
	public static final String crc64Table = "crc64Table";
	public static final String payload = "payload";
	public static final String offset = "offset";

	public Buffer() {
		super(Hooks.classNames.get("Buffer"));
	}
	
	public int[] getCrc32Table() {
		return (int[]) Hooks.selector.buffer.fields.get(crc32Table).getValue(reference);
	}
	
	public int[] getCrc64Table() {
		return (int[]) Hooks.selector.buffer.fields.get(crc64Table).getValue(reference);
	}
	
	public byte[] getPayload() {
		return (byte[]) Hooks.selector.buffer.fields.get(payload).getValue(reference);
	}
	
	public int getOffset() {
		return (int) Hooks.selector.buffer.fields.get(offset).getValue(reference);
	}

}
