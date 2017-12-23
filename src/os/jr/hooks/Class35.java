package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class35 extends GameClass{
	
	public static final String scriptStringStackSize = "scriptStringStackSize";

	public Class35() {
		super(Hooks.classNames.get("class35"));
	}

	public int getScriptStringStackSize() {
		return (int) fields.get(scriptStringStackSize).getValue(reference);
	}
}