package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class NpcComposition extends RSClass {

	public NpcComposition(Object reference) {
		this.reference = reference;
		if (Hooks.npcComposition != null) {
			this.fields = Hooks.npcComposition.fields;
			this.name = Hooks.npcComposition.name;
			this.obfuscatedName = Hooks.npcComposition.obfuscatedName;
		}
	}

	public String[] getActions() {
		return (String[]) getValue(getField("actions"));
	}

	public String getName() {
		if (this.reference == null)
			return "null";
		return (String) getValue(getField("name"));
	}

}
