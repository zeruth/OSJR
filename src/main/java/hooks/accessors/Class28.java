package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Class28 extends RSClass {

	public Class28(Object reference) {
		this.reference = reference;
		if (Hooks.class28 != null) {
			this.fields = Hooks.class28.fields;
			this.name = Hooks.class28.name;
			this.obfuscatedName = Hooks.class28.obfuscatedName;
		}
	}

	public int getCameraYaw() {
		return (int) getValue(getField("cameraYaw"));
	}
}
