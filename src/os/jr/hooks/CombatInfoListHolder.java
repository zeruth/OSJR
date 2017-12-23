package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class CombatInfoListHolder extends GameClass {

	public CombatInfoListHolder(Object reference) {
		super(Hooks.classNames.get("CombatInfoListHolder"));
		this.reference = reference;
	}

}
