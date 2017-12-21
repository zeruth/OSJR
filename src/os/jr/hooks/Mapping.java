package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Mapping extends GameClass {

	public Mapping(Object reference) {
		super(Hooks.classNames.get("Mapping"));
		this.reference = reference;
	}

}
