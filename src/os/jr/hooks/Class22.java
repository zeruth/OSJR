package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class22 extends RSClass{
	
	public static final String indexMaps = "indexMaps";

	public Class22() {
		super(Hooks.classNames.get("class22"));
	}
	
	public IndexData getIndexMaps() {
		return new IndexData(getField(indexMaps).getValue(reference));
	}

}