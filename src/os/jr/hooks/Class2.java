package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class2 extends GameClass{
	
	public static final String preferences = "preferences";

	public Class2() {
		super(Hooks.classNames.get("class2"));
	}
	
	public Preferences getPreferences() {
		return new Preferences(fields.get(preferences).getValue(reference));
	}

}
