package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class46 extends GameClass{
	
	public static final String baseX = "baseX";

	public Class46() {
		super(Hooks.classNames.get("class46"));
	}
	
	public int getBaseX() {
		return (int) fields.get(baseX).getValue(reference);
	}

}