package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class Ignore extends GameClass{

	public Ignore(Object reference) {
		super(Hooks.classNames.get("Ignore"));
		this.reference = reference;
	}

}
