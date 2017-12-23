package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class240 extends GameClass{
	
	public static final String cameraYaw = "cameraYaw";

	public Class240() {
		super(Hooks.classNames.get("class240"));
	}
	
	public int getCameraYaw() {
		return (int) fields.get(cameraYaw).getValue(reference);
	}

}