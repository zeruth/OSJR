package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class161 extends RSClass{
	
	public static final String indexScripts = "indexScripts";

	public Class161() {
		super(Hooks.classNames.get("class161"));
	}
	
	public IndexData getIndexScripts() {
		return new IndexData(getField(indexScripts).getValue(reference));
	}

}