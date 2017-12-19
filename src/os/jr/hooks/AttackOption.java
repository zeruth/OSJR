package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class AttackOption extends GameClass {


	public AttackOption(Object reference) {
		super(Hooks.classNames.get("AttackOption"));
		this.reference = reference;
	}

}
