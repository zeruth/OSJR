package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class FileSystem extends RSClass {
	
	public static final String fonts = "fonts";
	public static final String type = "type";
	public static final String index = "index";
	public static final String data = "data";

	public FileSystem() {
		super(Hooks.classNames.get("FileSystem"));
	}
	
	public Fonts getFonts() {
		return new Fonts(getField(fonts).getValue(reference));
	}
	
	public int getType() {
		return (int) getField(type).getValue(reference);
	}
	
	public IndexFile getIndex() {
		return new IndexFile(getField(index).getValue(reference));
	}
	
	public IndexData getData() {
		return new IndexData(getField(data).getValue(reference));
	}

}
