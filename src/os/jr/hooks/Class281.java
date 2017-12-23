package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class281 extends RSClass{
	
	public static final String scriptLocalInts = "scriptLocalInts";

	public Class281() {
		super(Hooks.classNames.get("class281"));
	}
	
	public int[] getScriptLocalInts() {
		return (int[]) getField(scriptLocalInts).getValue(reference);
	}

}