package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Deque extends GameClass{

	public Deque(Object reference) {
		super(Hooks.classNames.get("Deque"));
		this.reference = reference;
	}

}
