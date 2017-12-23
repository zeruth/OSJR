package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class20 extends RSClass{
	
	public static final String indexTrack2 = "indexTrack2";

	public Class20() {
		super(Hooks.classNames.get("class20"));
	}
	
	public IndexData getIndexTrack2() {
		return new IndexData(getField(indexTrack2).getValue(reference));
	}

}