package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class NPC extends RSClass {

	public NPC(Object reference) {
		super(Hooks.classNames.get("NPC"));
		this.reference = reference;
	}

}
