package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class281 extends GameClass{
	
	public static final String scriptLocalInts = "scriptLocalInts";

	public Class281() {
		super(Hooks.classNames.get("class281"));
	}
	
	public int[] getScriptLocalInts() {
		return (int[]) fields.get(scriptLocalInts).getValue(reference);
	}

}