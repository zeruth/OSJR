package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class161 extends GameClass{
	
	public static final String indexScripts = "indexScripts";

	public Class161() {
		super(Hooks.classNames.get("class161"));
	}
	
	public IndexData getIndexScripts() {
		return new IndexData(fields.get(indexScripts).getValue(reference));
	}

}