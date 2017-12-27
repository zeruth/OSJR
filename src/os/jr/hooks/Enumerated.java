package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Enumerated extends RSClass{
	
	public static final String rsOrdinal = "rsOrdinal";

	public Enumerated() {
		super(Hooks.classNames.get("Enumerated"));
	}
	
	public int getRsOrdinal() {
		return (int) getField(rsOrdinal).getValue(reference);
	}

}
