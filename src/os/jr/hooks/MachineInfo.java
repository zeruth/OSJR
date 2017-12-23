package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class MachineInfo extends GameClass {

	public MachineInfo(Object reference) {
		super(Hooks.classNames.get("MachineInfo"));
		this.reference = reference;
	}

}
