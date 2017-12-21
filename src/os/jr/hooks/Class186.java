package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class186 extends GameClass{
	
	public static final String currentTimeMsLast = "currentTimeMsLast";
	public static final String currentTimeMsOffset = "currentTimeMsOffset";

	public Class186() {
		super(Hooks.classNames.get("class186"));
	}
	
	public long getCurrentTimeMsLast() {
		return (long) fields.get(currentTimeMsLast).getValue(reference);
	}
	
	public long getCurrentTimeMsOffset() {
		return (long) fields.get(currentTimeMsOffset).getValue(reference);
	}

}