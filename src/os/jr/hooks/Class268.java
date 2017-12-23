package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class268 extends GameClass{
	
	public static final String myWorldPort = "myWorldPort";

	public Class268() {
		super(Hooks.classNames.get("class268"));
	}
	
	public int getMyWorldPort() {
		return (int) fields.get(myWorldPort).getValue(reference);
	}

}