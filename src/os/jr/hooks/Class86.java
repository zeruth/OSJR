package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class86 extends RSClass{
	
	public static final String indexCache4 = "indexCache4";

	public Class86() {
		super(Hooks.classNames.get("class86"));
	}
	
	public IndexData getIndexCache4() {
		return new IndexData(getField(indexCache4).getValue(reference));
	}

}