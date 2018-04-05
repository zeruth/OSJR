package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Class33 extends RSClass {

	public Class33(Object reference) {
		this.reference = reference;
		if (Hooks.class33 != null) {
			this.fields = Hooks.class33.fields;
			this.name = Hooks.class33.name;
			this.obfuscatedName = Hooks.class33.obfuscatedName;
		}
	}
}
