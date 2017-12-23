package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class CacheableNode extends RSClass {

	public static final String previous = "previous";
	public static final String next = "next";

	public CacheableNode(Object reference) {
		super(Hooks.classNames.get("CacheableNode"));
		this.reference = reference;
	}

	public CacheableNode(String className, Object reference) {
		super(className);
	}

	public CacheableNode getNext() {
		return new CacheableNode(getField(next).getValue(reference));
	}

	public CacheableNode getPrevious() {
		return new CacheableNode(getField(previous).getValue(reference));
	}

}
