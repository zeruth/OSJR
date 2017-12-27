package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Deque extends RSClass {
	
	public static final String head = "head";
	public static final String current = "current";

	public Deque(Object reference) {
		super(Hooks.classNames.get("Deque"));
		this.reference = reference;
	}
	
	public Node getHead() {
		return new Node(getField(head).getValue(reference));
	}
	
	public Node getCurrent() {
		return new Node(getField(current).getValue(reference));
	}

}
