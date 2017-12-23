package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class MouseRecorder extends GameClass {

	public MouseRecorder(Object reference) {
		super(Hooks.classNames.get("MouseRecorder"));
		this.reference = reference;
	}

}
