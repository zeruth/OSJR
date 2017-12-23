package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Task extends RSClass {

	public Task(Object reference) {
		super(Hooks.classNames.get("Task"));
		this.reference = reference;
	}

}
