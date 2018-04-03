package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Name extends RSClass {

	public Name(Object reference) {
		this.reference = reference;
		if (Hooks.name != null) {
			this.fields = Hooks.name.fields;
			this.name = Hooks.name.name;
			this.obfuscatedName = Hooks.name.obfuscatedName;
		}
	}

	public String getCleanName() {
		return (String) getValue(getField("cleanName"));
	}

	public String getOriginalName() {
		if (this.reference == null)
			return "null";
		return (String) getValue(getField("name"));
	}

}
