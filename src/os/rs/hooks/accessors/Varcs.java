package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.model.RSClass;

public class Varcs extends RSClass {

	public Varcs(Object reference) {
		this.reference = reference;
		if (Hooks.varcs != null) {
			this.fields = Hooks.ignore.fields;
			this.name = Hooks.ignore.name;
			this.obfuscatedName = Hooks.ignore.obfuscatedName;
		}

	}
}
