package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Sequence extends RSClass {

	public Sequence(Object reference) {
		this.reference = reference;
		if (Hooks.sequence != null) {
			this.fields = Hooks.sequence.fields;
			this.name = Hooks.sequence.name;
			this.obfuscatedName = Hooks.sequence.obfuscatedName;
		}
	}
}
