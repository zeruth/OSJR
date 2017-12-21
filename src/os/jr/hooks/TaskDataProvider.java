package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class TaskDataProvider extends GameClass {

	public TaskDataProvider(Object reference) {
		super(Hooks.classNames.get("TaskDataProvider"));
		this.reference = reference;
	}

}
