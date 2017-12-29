package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class FrameMap extends RSClass {

	public FrameMap(Object reference) {
		super(Hooks.classNames.get("FrameMap"));
		this.reference = reference;
	}

}
