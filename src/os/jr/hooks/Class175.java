package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class175 extends RSClass{
	
	public static final String socket = "socket";

	public Class175() {
		super(Hooks.classNames.get("class175"));
	}
	
	public Task getSocket() {
		return new Task(getField(socket).getValue(reference));
	}

}