package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class48 extends RSClass{
	
	public static final String platformInfo = "platformInfo";
	public static final String region = "region";

	public Class48() {
		super(Hooks.classNames.get("class48"));
	}
	
	public MachineInfo getPlatformInfo() {
		return new MachineInfo(getField(platformInfo).getValue(reference));
	}
	
	public Region getRegion() {
		return new Region(getField(region).getValue(reference));
	}

}