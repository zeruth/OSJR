package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class160 extends RSClass{
	
	public static final String cameraPitch = "cameraPitch";

	public Class160() {
		super(Hooks.classNames.get("class150"));
	}
	
	public int getCameraPitch() {
		return (int) getField(cameraPitch).getValue(reference);
	}

}