package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class211 extends GameClass{
	
	public static final String queue = "queue";

	public Class211() {
		super(Hooks.classNames.get("class211"));
	}
	
	public IterableDualNodeQueue getQueue() {
		return new IterableDualNodeQueue(fields.get(queue).getValue(reference));
	}

}