package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class299 extends RSClass{
	
	public static final String offsetsY = "offsetsY";

	public Class299() {
		super(Hooks.classNames.get("class299"));
	}
	
	public int[] getOffsetsY() {
		return (int[]) getField(offsetsY).getValue(reference);
	}

}