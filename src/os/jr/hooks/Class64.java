package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class64 extends GameClass{
	
	public static final String mapRegions = "mapRegions";

	public Class64() {
		super(Hooks.classNames.get("class64"));
	}
	
	public int[] getMapRegions() {
		return (int[]) fields.get(mapRegions).getValue(reference);
	}

}