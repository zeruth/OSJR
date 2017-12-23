package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class293 extends GameClass{
	
	public static final String class293 = "class293";

	public Class293() {
		super(Hooks.classNames.get("class293"));
	}
	
	public CombatInfoList getClassInfos() {
		return new CombatInfoList(fields.get(class293).getValue(reference));
	}

}