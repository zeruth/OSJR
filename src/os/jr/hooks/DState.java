package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class DState extends RSClass {

	public DState(Object reference) {
		super(Hooks.classNames.get("DState"));
		this.reference = reference;
	}

}
