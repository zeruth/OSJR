package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class3 extends GameClass{
	
	public static final String rssocket = "rssocket";
	public static final String indexTextures = "indexTextures";

	public Class3() {
		super(Hooks.classNames.get("class3"));
	}
	
	public Class159 getRssocket() {
		return new Class159(fields.get(rssocket).getValue(reference));
	}
	
	public Class159 getIndexTextures() {
		return new Class159(fields.get(indexTextures).getValue(reference));
	}

}
