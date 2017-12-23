package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class64 extends RSClass{
	
	public static final String mapRegions = "mapRegions";

	public Class64() {
		super(Hooks.classNames.get("class64"));
	}
	
	public int[] getMapRegions() {
		return (int[]) getField(mapRegions).getValue(reference);
	}

}