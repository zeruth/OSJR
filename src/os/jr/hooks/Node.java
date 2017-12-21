package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Node extends GameClass{

	public Node() {
		super(Hooks.classNames.get("Node"));
	}

	public Node(String className) {
		super(className);
	}
}
