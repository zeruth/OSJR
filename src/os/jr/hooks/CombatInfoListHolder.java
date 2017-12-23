package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class CombatInfoListHolder extends RSClass {
	
	public static final String combatInfo2 = "combatInfo2";
	public static final String combatInfo1 = "combatInfo1";

	public CombatInfoListHolder(Object reference) {
		super(Hooks.classNames.get("CombatInfoListHolder"));
		this.reference = reference;
	}
	
	public CombatInfo2 getCombatInfo2() {
		return new CombatInfo2(getField(combatInfo2).getValue(reference));
	}
	
	public CombatInfoList getSombatInfo1() {
		return new CombatInfoList(getField(combatInfo1).getValue(reference));
	}

}
