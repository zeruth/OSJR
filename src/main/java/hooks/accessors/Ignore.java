package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Ignore extends RSClass {

	public Ignore(Object reference) {
		this.reference = reference;
		if (Hooks.ignore != null) {
			this.fields = Hooks.ignore.fields;
			this.name = Hooks.ignore.name;
			this.obfuscatedName = Hooks.ignore.obfuscatedName;
		}
	}
}
