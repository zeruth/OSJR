package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class CacheFile extends GameClass {

	public static final String accessFile = "accessFile";
	public static final String readPayload = "readPayload";
	public static final String writePayload = "writePayload";
	public static final String position = "position";
	public static final String length = "length";
	public static final String capacity = "capacity";

	public CacheFile(Object reference) {
		super(Hooks.classNames.get("CacheFile"));
		this.reference = reference;
	}

	public FileOnDisk getAccessFile() {
		return new FileOnDisk(fields.get(accessFile).getValue(reference));
	}

	public long getCapacity() {
		return (long) fields.get(capacity).getValue(reference);
	}

	public long getLength() {
		return (long) fields.get(length).getValue(reference);
	}

	public long getPosition() {
		return (long) fields.get(position).getValue(reference);
	}

	public byte[] readPayload() {
		return (byte[]) fields.get(readPayload).getValue(reference);
	}

	public byte[] writePayload() {
		return (byte[]) fields.get(writePayload).getValue(reference);
	}

}
