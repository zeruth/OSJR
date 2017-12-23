package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class IndexData extends RSClass {

	public IndexData(Object reference) {
		super(Hooks.classNames.get("IndexData"));
		this.reference = reference;
	}

}
