package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class48 extends GameClass{
	
	public static final String platformInfo = "platformInfo";
	public static final String region = "region";

	public Class48() {
		super(Hooks.classNames.get("class48"));
	}
	
	public MachineInfo getPlatformInfo() {
		return new MachineInfo(fields.get(platformInfo).getValue(reference));
	}
	
	public Region getRegion() {
		return new Region(fields.get(region).getValue(reference));
	}

}