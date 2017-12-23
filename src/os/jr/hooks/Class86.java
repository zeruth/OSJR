package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class86 extends GameClass{
	
	public static final String indexCache4 = "indexCache4";

	public Class86() {
		super(Hooks.classNames.get("class86"));
	}
	
	public IndexData getIndexCache4() {
		return new IndexData(fields.get(indexCache4).getValue(reference));
	}

}