package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class20 extends GameClass{
	
	public static final String indexTrack2 = "indexTrack2";

	public Class20() {
		super(Hooks.classNames.get("class20"));
	}
	
	public IndexData getIndexTrack2() {
		return new IndexData(fields.get(indexTrack2).getValue(reference));
	}

}