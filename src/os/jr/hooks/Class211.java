package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class211 extends RSClass{
	
	public static final String queue = "queue";

	public Class211() {
		super(Hooks.classNames.get("class211"));
	}
	
	public IterableDualNodeQueue getQueue() {
		return new IterableDualNodeQueue(getField(queue).getValue(reference));
	}

}