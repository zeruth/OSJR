package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class AttackOption extends GameClass {


	public AttackOption(Object reference) {
		super(Hooks.classNames.get("AttackOption"));
		this.reference = reference;
	}

}
