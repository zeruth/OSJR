package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class ScriptState extends RSClass {

	public ScriptState(Object reference) {
		super(Hooks.classNames.get("ScriptState"));
		this.reference = reference;
	}

}
