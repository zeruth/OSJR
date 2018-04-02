package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Nameable extends RSClass {

	public Nameable(Object reference) {
		this.reference = reference;
		if (Hooks.nameable != null) {
			this.fields = Hooks.nameable.fields;
			this.name = Hooks.nameable.name;
			this.obfuscatedName = Hooks.nameable.obfuscatedName;
		}
	}

	public Object getName() {
		return getValue(getField("name"));
	}

}
