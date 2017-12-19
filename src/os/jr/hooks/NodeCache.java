package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class NodeCache extends GameClass{

	public NodeCache(Object reference) {
		super(Hooks.classNames.get("NodeCache"));
		this.reference=reference;
	}

}
