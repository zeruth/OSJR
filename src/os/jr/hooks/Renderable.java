package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Renderable extends GameClass{

	public Renderable() {
		super(Hooks.classNames.get("Renderable"));
	}

	public Renderable(String className) {
		super(className);
	}

}
