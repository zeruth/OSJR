package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Fonts extends RSClass {
	
	public static final String configsIndex = "configsIndex";

	public Fonts(Object reference) {
		super(Hooks.classNames.get("Fonts"));
		this.reference = reference;
	}
	
	public IndexData getConfigsIndex() {
		return new IndexData(getField(configsIndex).getValue(reference));
	}

}
