package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class ScriptState extends GameClass {

	public ScriptState(Object reference) {
		super(Hooks.classNames.get("ScriptState"));
		this.reference = reference;
	}

}
