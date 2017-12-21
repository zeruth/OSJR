package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class175 extends GameClass{
	
	public static final String socket = "socket";

	public Class175() {
		super(Hooks.classNames.get("class175"));
	}
	
	public Task getSocket() {
		return new Task(fields.get(socket).getValue(reference));
	}

}