package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.model.RSClass;

public class Class38 extends RSClass {

	public Class38(Object reference) {
		this.reference = reference;
		if (Hooks.class38 != null) {
			this.fields = Hooks.class38.fields;
			this.name = Hooks.class38.name;
			this.obfuscatedName = Hooks.class38.obfuscatedName;
		}
	}
}
