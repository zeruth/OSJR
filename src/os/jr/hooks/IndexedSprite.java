package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class IndexedSprite extends GameClass {

	public IndexedSprite(Object reference) {
		super(Hooks.classNames.get("IndexedSprite"));
		this.reference = reference;
	}

}
