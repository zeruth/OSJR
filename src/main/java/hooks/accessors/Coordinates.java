package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Coordinates extends RSClass {
	
	int plane;

	public Coordinates(Object reference) {
		this.reference = reference;
		if (Hooks.coordinates != null) {
			this.fields = Hooks.coordinates.fields;
			this.name = Hooks.coordinates.name;
			this.obfuscatedName = Hooks.coordinates.obfuscatedName;
		}
	}

	public int getPlane() {
		this.plane = (int) getValue(getField("plane"));
		return this.plane;
	}
}
