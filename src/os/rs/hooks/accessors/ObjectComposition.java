package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.model.RSClass;

public class ObjectComposition extends RSClass {

	public ObjectComposition(Object reference) {
		this.reference = reference;
		if (Hooks.npcComposition != null) {
			this.fields = Hooks.npcComposition.fields;
			this.name = Hooks.npcComposition.name;
			this.obfuscatedName = Hooks.npcComposition.obfuscatedName;
		}
	}

	public int getID() {
		return (int) getValue(getField("id"));
	}

}
