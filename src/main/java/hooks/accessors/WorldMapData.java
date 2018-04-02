package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class WorldMapData extends RSClass {

	public WorldMapData(Object reference) {
		this.reference = reference;
		if (Hooks.worldMapData != null) {
			this.fields = Hooks.worldMapData.fields;
			this.name = Hooks.worldMapData.name;
			this.obfuscatedName = Hooks.worldMapData.obfuscatedName;
		}
	}
}
