package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Class237 extends RSClass {

	public Class237(Object reference) {
		this.reference = reference;
		if (Hooks.class237 != null) {
			this.fields = Hooks.class237.fields;
			this.name = Hooks.class237.name;
			this.obfuscatedName = Hooks.class237.obfuscatedName;
		}
	}

	public int getPlane() {
		return (int) getValue(getField("plane"));
	}
}
