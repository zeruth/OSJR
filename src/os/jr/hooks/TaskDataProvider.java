package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class TaskDataProvider extends RSClass {

	public TaskDataProvider(Object reference) {
		super(Hooks.classNames.get("TaskDataProvider"));
		this.reference = reference;
	}

}
