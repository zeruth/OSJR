package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class3 extends RSClass{
	
	public static final String rssocket = "rssocket";
	public static final String indexTextures = "indexTextures";

	public Class3() {
		super(Hooks.classNames.get("class3"));
	}
	
	public Class159 getRssocket() {
		return new Class159(getField(rssocket).getValue(reference));
	}
	
	public Class159 getIndexTextures() {
		return new Class159(getField(indexTextures).getValue(reference));
	}

}
