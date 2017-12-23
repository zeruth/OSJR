package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Coordinates extends RSClass {
	
	public static final String plane = "plane";
	public static final String worldX = "worldX";
	public static final String worldY = "worldY";

	public Coordinates() {
		super(Hooks.classNames.get("Coordinates"));
	}
	
	public int getPlane() {
		return (int) getField(plane).getValue(reference);
	}
	
	public int getWorldX() {
		return (int) getField(worldX).getValue(reference);
	}
	
	public int getWorldY() {
		return (int) getField(worldY).getValue(reference);
	}

}
