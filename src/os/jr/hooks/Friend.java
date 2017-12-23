package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Friend extends RSClass {

	public Friend(Object reference) {
		super(Hooks.classNames.get("Friend"));
		this.reference = reference;
	}

}
