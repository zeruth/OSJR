package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class TaskDataProvider extends GameClass{
	
	public TaskDataProvider(Object reference) {
		super(Hooks.classNames.get("TaskDataProvider"));
		this.reference=reference;
	}

}
