package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class CombatInfoList extends GameClass{

	public CombatInfoList(Object reference) {
		super(Hooks.classNames.get("CombatInfoList"));
		this.reference=reference;
	}

}
