package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class FaceNormal extends RSClass {
	
	public static final String x = "x";
	public static final String y = "y";
	public static final String z = "z";

	public FaceNormal(Object reference) {
		super(Hooks.classNames.get("FaceNormal"));
		this.reference = reference;
	}
	
	public int getX() {
		return (int) getField(x).getValue(reference);
	}
	
	public int getY() {
		return (int) getField(y).getValue(reference);
	}
	
	public int getZ() {
		return (int) getField(z).getValue(reference);
	}

}
