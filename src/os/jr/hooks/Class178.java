package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class178 extends RSClass{
	
	public static final String state = "state";

	public Class178() {
		super(Hooks.classNames.get("class178"));
	}
	
	public DState getState() {
		return new DState(getField(state).getValue(reference));
	}

}