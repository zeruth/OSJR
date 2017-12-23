package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Region extends RSClass {

	public Region(Object reference) {
		super(Hooks.classNames.get("Region"));
		this.reference = reference;
	}

}
