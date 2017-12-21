package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class160 extends GameClass{
	
	public static final String cameraPitch = "cameraPitch";

	public Class160() {
		super(Hooks.classNames.get("class150"));
	}
	
	public int getCameraPitch() {
		return (int) fields.get(cameraPitch).getValue(reference);
	}

}