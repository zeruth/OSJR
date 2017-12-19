package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class NPC extends GameClass{

	public NPC(Object reference) {
		super(Hooks.classNames.get("NPC"));
		this.reference = reference;
	}

}
