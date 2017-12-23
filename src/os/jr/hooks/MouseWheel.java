package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class MouseWheel extends RSClass {

	public MouseWheel(Object reference) {
		super(Hooks.classNames.get("MouseWheel"));
		this.reference = reference;
	}

}
