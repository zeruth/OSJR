package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class29 extends GameClass{
	
	public static final String indexTrack1 = "indexTrack1";

	public Class29() {
		super(Hooks.classNames.get("class29"));
	}
	
	public IndexData getIndexTrack1() {
		return new IndexData(fields.get(indexTrack1).getValue(reference));
	}

}