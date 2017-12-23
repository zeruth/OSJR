package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class43 extends RSClass{
	
	public static final String indexSprites = "indexSprites";

	public Class43() {
		super(Hooks.classNames.get("class43"));
	}
	
	public IndexData getIndexSprites() {
		return new IndexData(getField(indexSprites).getValue(reference));
	}

}