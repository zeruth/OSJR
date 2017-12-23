package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class186 extends RSClass{
	
	public static final String currentTimeMsLast = "currentTimeMsLast";
	public static final String currentTimeMsOffset = "currentTimeMsOffset";

	public Class186() {
		super(Hooks.classNames.get("class186"));
	}
	
	public long getCurrentTimeMsLast() {
		return (long) getField(currentTimeMsLast).getValue(reference);
	}
	
	public long getCurrentTimeMsOffset() {
		return (long) getField(currentTimeMsOffset).getValue(reference);
	}

}