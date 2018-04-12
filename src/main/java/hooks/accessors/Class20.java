package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Class20 extends RSClass {

	int cameraY;

	public Class20(Object reference) {
		this.reference = reference;
		if (Hooks.class20 != null) {
			this.fields = Hooks.class20.fields;
			this.name = Hooks.class20.name;
			this.obfuscatedName = Hooks.class20.obfuscatedName;
		}
	}

	public int getCameraY() {
		this.cameraY = (int) getValue(getField("cameraY"));
		return this.cameraY;
	}
}
