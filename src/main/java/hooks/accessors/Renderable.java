package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Renderable extends RSClass {

	public Renderable(Object reference) {
		this.reference = reference;
		if (Hooks.actor != null) {
			fields = Hooks.actor.fields;
			name = Hooks.actor.name;
			obfuscatedName = Hooks.actor.obfuscatedName;
		}
	}

}
