package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class240 extends RSClass{
	
	public static final String cameraYaw = "cameraYaw";

	public Class240() {
		super(Hooks.classNames.get("class240"));
	}
	
	public int getCameraYaw() {
		return (int) getField(cameraYaw).getValue(reference);
	}

}