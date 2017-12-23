package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Buffer extends GameClass {

	public static final String crc32Table = "crc32Table";
	public static final String crc64Table = "crc64Table";
	public static final String payload = "payload";
	public static final String offset = "offset";

	public Buffer(Object reference) {
		super(Hooks.classNames.get("Buffer"));
		this.reference = reference;
	}

	public int[] getCrc32Table() {
		return (int[]) fields.get(crc32Table).getValue(reference);
	}

	public int[] getCrc64Table() {
		return (int[]) fields.get(crc64Table).getValue(reference);
	}

	public int getOffset() {
		return (int) fields.get(offset).getValue(reference);
	}

	public byte[] getPayload() {
		return (byte[]) fields.get(payload).getValue(reference);
	}

}
