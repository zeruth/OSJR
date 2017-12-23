package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Renderable extends RSClass {

	public Renderable(Object reference) {
		super(Hooks.classNames.get("Renderable"));
		this.reference = reference;
	}

}
