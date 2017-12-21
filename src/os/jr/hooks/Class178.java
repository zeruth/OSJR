package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class178 extends GameClass{
	
	public static final String state = "state";

	public Class178() {
		super(Hooks.classNames.get("class178"));
	}
	
	public DState getState() {
		return new DState(fields.get(state).getValue(reference));
	}

}