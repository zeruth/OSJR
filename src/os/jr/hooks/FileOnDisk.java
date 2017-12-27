package os.jr.hooks;

import java.io.RandomAccessFile;

import os.jr.hooks.loader.RSClass;

public class FileOnDisk extends RSClass {
	
	public static final String port2 = "port2";
	public static final String file = "file";
	public static final String length = "length";
	public static final String position = "position";

	public FileOnDisk(Object reference) {
		super(Hooks.classNames.get("FileOnDisk"));
		this.reference = reference;
	}
	
	public int getPort2() {
		return (int) getField(port2).getValue(reference);
	}
	
	public RandomAccessFile getFile() {
		return (RandomAccessFile) getField(file).getValue(reference);
	}
	
	public long getPosition() {
		return (int) getField(position).getValue(reference);
	}

}
