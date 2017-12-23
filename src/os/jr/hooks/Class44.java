package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class44 extends GameClass{
	
	public static final String mouseRecorder = "mouseRecorder";

	public Class44() {
		super(Hooks.classNames.get("class44"));
	}
	
	public MouseRecorder getMouseRecorder() {
		return new MouseRecorder(fields.get(mouseRecorder).getValue(reference));
	}

}