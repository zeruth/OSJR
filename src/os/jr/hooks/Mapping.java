package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Mapping extends RSClass {

	public Mapping(Object reference) {
		super(Hooks.classNames.get("Mapping"));
		this.reference = reference;
	}

}
