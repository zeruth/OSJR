package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class21 extends GameClass{
	
	public static final String xteaKeys = "xteaKeys";

	public Class21() {
		super(Hooks.classNames.get("class21"));
	}
	
	public int[][] getXTeaKeys() {
		return (int[][]) fields.get(xteaKeys).getValue(reference);
	}

}