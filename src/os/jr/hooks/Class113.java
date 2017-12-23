package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class113 extends RSClass{
	
	public static final String validInterfaces = "validInterfaces";
	public static final String cacheLocations = "cacheLocations";

	public Class113() {
		super(Hooks.classNames.get("class113"));
	}
	
	public boolean[] getValidInterfaces() {
		return (boolean[]) getField(validInterfaces).getValue(reference);
	}
	
	public String[] getCacheLocations() {
		return (String[]) getField(validInterfaces).getValue(reference);
	}

}