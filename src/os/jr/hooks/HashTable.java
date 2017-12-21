package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class HashTable extends GameClass{

	public HashTable(Object reference) {
		super(Hooks.classNames.get("HashTable"));
		this.reference = reference;
	}

}
