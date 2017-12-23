package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class IterableHashTable extends RSClass {

	public IterableHashTable(Object reference) {
		super(Hooks.classNames.get("IterableHashTable"));
		this.reference = reference;
	}

}
