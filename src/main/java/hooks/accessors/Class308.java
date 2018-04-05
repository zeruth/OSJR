package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Class308 extends RSClass {

	public Class308(Object reference) {
		this.reference = reference;
		if (Hooks.class308 != null) {
			this.fields = Hooks.class308.fields;
			this.name = Hooks.class308.name;
			this.obfuscatedName = Hooks.class308.obfuscatedName;
		}
	}
}
