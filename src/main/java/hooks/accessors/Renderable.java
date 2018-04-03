package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Renderable extends RSClass {

	public Renderable(Object reference) {
		this.reference = reference;
		if (Hooks.actor != null) {
			this.fields = Hooks.actor.fields;
			this.name = Hooks.actor.name;
			this.obfuscatedName = Hooks.actor.obfuscatedName;
		}
	}

}
