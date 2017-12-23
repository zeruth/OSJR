package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class21 extends RSClass{
	
	public static final String xteaKeys = "xteaKeys";

	public Class21() {
		super(Hooks.classNames.get("class21"));
	}
	
	public int[][] getXTeaKeys() {
		return (int[][]) getField(xteaKeys).getValue(reference);
	}

}