package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class46 extends RSClass{
	
	public static final String baseX = "baseX";

	public Class46() {
		super(Hooks.classNames.get("class46"));
	}
	
	public int getBaseX() {
		return (int) getField(baseX).getValue(reference);
	}

}