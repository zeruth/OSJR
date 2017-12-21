package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class1 extends GameClass{
	
	public static final String userHome = "userHome";

	public Class1() {
		super(Hooks.classNames.get("class1"));
	}
	
	public String getUserHome() {
		return (String) fields.get(userHome).getValue(reference);
	}

}
