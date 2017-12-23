package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class IterableHashTable extends GameClass {

	public IterableHashTable(Object reference) {
		super(Hooks.classNames.get("IterableHashTable"));
		this.reference = reference;
	}

}
