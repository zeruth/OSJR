package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class2 extends RSClass{
	
	public static final String preferences = "preferences";

	public Class2() {
		super(Hooks.classNames.get("class2"));
	}
	
	public Preferences getPreferences() {
		return new Preferences(getField(preferences).getValue(reference));
	}

}
