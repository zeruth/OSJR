package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class HashTable extends RSClass {

	public HashTable(Object reference) {
		super(Hooks.classNames.get("HashTable"));
		this.reference = reference;
	}

}
