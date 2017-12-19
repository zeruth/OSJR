package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class CacheableNode extends GameClass{

	public CacheableNode() {
		super(Hooks.classNames.get("CacheableNode"));
	}

	public CacheableNode(String className) {
		super(className);
	}

}
