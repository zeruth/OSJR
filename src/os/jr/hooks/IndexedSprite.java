package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class IndexedSprite extends RSClass {

	public IndexedSprite(Object reference) {
		super(Hooks.classNames.get("IndexedSprite"));
		this.reference = reference;
	}

}
