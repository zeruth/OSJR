package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class293 extends RSClass{
	
	public static final String class293 = "class293";

	public Class293() {
		super(Hooks.classNames.get("class293"));
	}
	
	public CombatInfoList getClassInfos() {
		return new CombatInfoList(getField(class293).getValue(reference));
	}

}