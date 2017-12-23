package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class44 extends RSClass{
	
	public static final String mouseRecorder = "mouseRecorder";

	public Class44() {
		super(Hooks.classNames.get("class44"));
	}
	
	public MouseRecorder getMouseRecorder() {
		return new MouseRecorder(getField(mouseRecorder).getValue(reference));
	}

}