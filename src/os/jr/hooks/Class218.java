package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class218 extends RSClass{
	
	public static final String priority = "priority";

	public Class218() {
		super(Hooks.classNames.get("class218"));
	}
	
	public int getPriority() {
		return (int) getField(priority).getValue(reference);
	}

}