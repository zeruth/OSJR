package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class CacheableNode extends GameClass{
	
	public static final String previous = "previous";
	public static final String next = "next";

	public CacheableNode(Object reference) {
		super(Hooks.classNames.get("CacheableNode"));
		this.reference=reference;
	}

	public CacheableNode(String className, Object reference) {
		super(className);
	}
	
	public CacheableNode getPrevious() {
		return new CacheableNode(Hooks.selector.cacheableNode.fields.get(previous).getValue(reference));
	}
	
	public CacheableNode getNext() {
		return new CacheableNode(Hooks.selector.cacheableNode.fields.get(next).getValue(reference));
	}

}
