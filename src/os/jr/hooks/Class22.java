package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class22 extends GameClass{
	
	public static final String indexMaps = "indexMaps";

	public Class22() {
		super(Hooks.classNames.get("class22"));
	}
	
	public IndexData getIndexMaps() {
		return new IndexData(fields.get(indexMaps).getValue(reference));
	}

}