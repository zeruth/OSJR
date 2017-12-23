package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class CacheFile extends RSClass {

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
		return new FileOnDisk(getField(accessFile).getValue(reference));
	}

	public long getCapacity() {
		return (long) getField(capacity).getValue(reference);
	}

	public long getLength() {
		return (long) getField(length).getValue(reference);
	}

	public long getPosition() {
		return (long) getField(position).getValue(reference);
	}

	public byte[] readPayload() {
		return (byte[]) getField(readPayload).getValue(reference);
	}

	public byte[] writePayload() {
		return (byte[]) getField(writePayload).getValue(reference);
	}

}
