package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class218 extends GameClass{
	
	public static final String priority = "priority";

	public Class218() {
		super(Hooks.classNames.get("class218"));
	}
	
	public int getPriority() {
		return (int) fields.get(priority).getValue(reference);
	}

}