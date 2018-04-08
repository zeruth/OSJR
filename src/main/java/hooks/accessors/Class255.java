package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Class255 extends RSClass {
	
	Region region;

	public Class255(Object reference) {
		this.reference = reference;
		if (Hooks.class255 != null) {
			this.fields = Hooks.class255.fields;
			this.name = Hooks.class255.name;
			this.obfuscatedName = Hooks.class255.obfuscatedName;
		}
	}

	public Region getRegion() {
		this.region = new Region(getValue(getField("region")));
		return this.region;
	}

}
