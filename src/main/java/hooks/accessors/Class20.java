package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Class20 extends RSClass {

	public Class20(Object reference) {
		this.reference = reference;
		if (Hooks.class20 != null) {
			this.fields = Hooks.class20.fields;
			this.name = Hooks.class20.name;
			this.obfuscatedName = Hooks.class20.obfuscatedName;
		}
	}
	
	public int getCameraY() {
		return (int) getValue(getField("cameraY"));
	}
}
