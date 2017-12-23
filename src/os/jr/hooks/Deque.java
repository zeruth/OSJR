package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Deque extends RSClass {

	public Deque(Object reference) {
		super(Hooks.classNames.get("Deque"));
		this.reference = reference;
	}

}
