package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class CombatInfoList extends GameClass{

	public CombatInfoList(Object reference) {
		super(Hooks.classNames.get("CombatInfoList"));
		this.reference=reference;
	}

}
