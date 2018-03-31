package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.model.RSClass;

public class Coordinates extends RSClass {

	public Coordinates(Object reference) {
		this.reference = reference;
		if (Hooks.coordinates != null) {
			this.fields = Hooks.coordinates.fields;
			this.name = Hooks.coordinates.name;
			this.obfuscatedName = Hooks.coordinates.obfuscatedName;
		}
	}

	public int getPlane() {
		return (int) getValue(getField("plane"));
	}
}
