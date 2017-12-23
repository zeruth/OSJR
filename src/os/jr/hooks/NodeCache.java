package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class NodeCache extends RSClass {

	public NodeCache(Object reference) {
		super(Hooks.classNames.get("NodeCache"));
		this.reference = reference;
	}

}
