package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class299 extends GameClass{
	
	public static final String offsetsY = "offsetsY";

	public Class299() {
		super(Hooks.classNames.get("class299"));
	}
	
	public int[] getOffsetsY() {
		return (int[]) fields.get(offsetsY).getValue(reference);
	}

}