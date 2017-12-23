package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class35 extends RSClass{
	
	public static final String scriptStringStackSize = "scriptStringStackSize";

	public Class35() {
		super(Hooks.classNames.get("class35"));
	}

	public int getScriptStringStackSize() {
		return (int) getField(scriptStringStackSize).getValue(reference);
	}
}