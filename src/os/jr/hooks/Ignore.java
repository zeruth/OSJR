package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Ignore extends RSClass {

	public Ignore(Object reference) {
		super(Hooks.classNames.get("Ignore"));
		this.reference = reference;
	}

}
