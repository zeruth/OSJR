package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Preferences extends RSClass {

	public Preferences(Object reference) {
		super(Hooks.classNames.get("Preferences"));
		this.reference = reference;
	}

}
