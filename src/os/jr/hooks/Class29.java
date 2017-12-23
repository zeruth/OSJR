package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class29 extends RSClass{
	
	public static final String indexTrack1 = "indexTrack1";

	public Class29() {
		super(Hooks.classNames.get("class29"));
	}
	
	public IndexData getIndexTrack1() {
		return new IndexData(getField(indexTrack1).getValue(reference));
	}

}