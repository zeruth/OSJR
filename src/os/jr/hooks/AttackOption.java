package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class AttackOption extends RSClass {

	public AttackOption(Object reference) {
		super(Hooks.classNames.get("AttackOption"));
		this.reference = reference;
	}

}
