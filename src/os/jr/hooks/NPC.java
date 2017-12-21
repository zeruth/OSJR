package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class NPC extends GameClass {

	public NPC(Object reference) {
		super(Hooks.classNames.get("NPC"));
		this.reference = reference;
	}

}
