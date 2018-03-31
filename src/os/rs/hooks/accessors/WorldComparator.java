package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.model.RSClass;

public class WorldComparator extends RSClass {

	public WorldComparator(Object reference) {
		this.reference = reference;
		if (Hooks.worldComparator != null) {
			this.fields = Hooks.worldComparator.fields;
			this.name = Hooks.worldComparator.name;
			this.obfuscatedName = Hooks.worldComparator.obfuscatedName;
		}
	}

	public Player getLocalPlayer() {
		this.reference = null;
		return new Player(getValue(getField("localPlayer")));
	}
}