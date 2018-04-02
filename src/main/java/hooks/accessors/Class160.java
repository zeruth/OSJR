package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Class160 extends RSClass {

	public Class160(Object reference) {
		this.reference = reference;
		if (Hooks.class160 != null) {
			this.fields = Hooks.class160.fields;
			this.name = Hooks.class160.name;
			this.obfuscatedName = Hooks.class160.obfuscatedName;
		}
	}
}
