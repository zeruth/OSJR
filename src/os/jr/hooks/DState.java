package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class DState extends GameClass {

	public DState(Object reference) {
		super(Hooks.classNames.get("DState"));
		this.reference = reference;
	}

}
