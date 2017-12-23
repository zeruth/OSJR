package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class1 extends RSClass{
	
	public static final String userHome = "userHome";

	public Class1() {
		super(Hooks.classNames.get("class1"));
	}
	
	public String getUserHome() {
		return (String) getField(userHome).getValue(reference);
	}

}
