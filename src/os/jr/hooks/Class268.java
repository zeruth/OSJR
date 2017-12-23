package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class268 extends RSClass{
	
	public static final String myWorldPort = "myWorldPort";

	public Class268() {
		super(Hooks.classNames.get("class268"));
	}
	
	public int getMyWorldPort() {
		return (int) getField(myWorldPort).getValue(reference);
	}

}