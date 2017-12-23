package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class CollisionData extends RSClass {
	
	public static final String x = "x";
	public static final String y = "y";
	public static final String width = "width";
	public static final String height = "height";
	public static final String flags = "flags";

	public CollisionData(Object reference) {
		super(Hooks.classNames.get("CollisionData"));
		this.reference = reference;
	}
	
	public int getX() {
		return (int) getField(x).getValue(reference);
	}
	
	public int getY() {
		return (int) getField(y).getValue(reference);
	}
	
	public int getWidth() {
		return (int) getField(width).getValue(reference);
	}
	
	public int getHeight() {
		return (int) getField(height).getValue(reference);
	}
	
	public int[][] getFlags() {
		return (int[][]) getField(flags).getValue(reference);
	}

}
