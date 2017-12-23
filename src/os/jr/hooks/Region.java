package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Region extends GameClass {

	public Region(Object reference) {
		super(Hooks.classNames.get("Region"));
		this.reference = reference;
	}

}
