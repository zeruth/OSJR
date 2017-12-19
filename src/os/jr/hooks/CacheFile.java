package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class CacheFile extends GameClass{
	
	public static final String accessFile = "accessFile";
	public static final String readPayload = "readPayload";
	public static final String writePayload = "writePayload";
	public static final String position = "position";
	public static final String length = "length";
	public static final String capacity = "capacity";

	public CacheFile() {
		super(Hooks.classNames.get("CacheFile"));
	}
	
	public FileOnDisk getAccessFile() {
		return new FileOnDisk(Hooks.selector.cacheFile.fields.get(accessFile).getValue(reference));
	}
	
	public byte[] readPayload() {
		return (byte[]) Hooks.selector.cacheFile.fields.get(readPayload).getValue(reference);
	}
	
	public byte[] writePayload() {
		return (byte[]) Hooks.selector.cacheFile.fields.get(writePayload).getValue(reference);
	}
	
	public long getPosition() {
		return (long) Hooks.selector.cacheFile.fields.get(position).getValue(reference);
	}
	
	public long getLength() {
		return (long) Hooks.selector.cacheFile.fields.get(length).getValue(reference);
	}
	
	public long getCapacity() {
		return (long) Hooks.selector.cacheFile.fields.get(capacity).getValue(reference);
	}

}
