package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class43 extends GameClass{
	
	public static final String indexSprites = "indexSprites";

	public Class43() {
		super(Hooks.classNames.get("class43"));
	}
	
	public IndexData getIndexSprites() {
		return new IndexData(fields.get(indexSprites).getValue(reference));
	}

}