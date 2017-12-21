package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class113 extends GameClass{
	
	public static final String validInterfaces = "validInterfaces";
	public static final String cacheLocations = "cacheLocations";

	public Class113() {
		super(Hooks.classNames.get("class113"));
	}
	
	public boolean[] getValidInterfaces() {
		return (boolean[]) fields.get(validInterfaces).getValue(reference);
	}
	
	public String[] getCacheLocations() {
		return (String[]) fields.get(validInterfaces).getValue(reference);
	}

}