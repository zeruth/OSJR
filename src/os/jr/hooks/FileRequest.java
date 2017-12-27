package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class FileRequest extends RSClass {
	
	public static final String index = "index";
	public static final String crc = "crc";

	public FileRequest() {
		super(Hooks.classNames.get("FileRequest"));
	}
	
	public IndexData getIndex() {
		return new IndexData(getField(index).getValue(reference));
	}
	
	public int getCRC() {
		return (int) getField(crc).getValue(reference);
	}

}
