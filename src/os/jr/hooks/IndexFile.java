package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class IndexFile extends RSClass {

	public IndexFile(Object reference) {
		super(Hooks.classNames.get("IndexFile"));
		this.reference = reference;
	}

}
