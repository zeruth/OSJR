package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class MouseRecorder extends RSClass {

	public MouseRecorder(Object reference) {
		super(Hooks.classNames.get("MouseRecorder"));
		this.reference = reference;
	}

}
