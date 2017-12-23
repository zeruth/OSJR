package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class MachineInfo extends RSClass {

	public MachineInfo(Object reference) {
		super(Hooks.classNames.get("MachineInfo"));
		this.reference = reference;
	}

}
