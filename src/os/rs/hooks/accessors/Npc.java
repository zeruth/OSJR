package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.model.RSClass;

public class Npc extends RSClass {

	public Npc(Object reference) {
		this.reference = reference;
		if (Hooks.npc != null) {
			this.fields = Hooks.npc.fields;
			this.name = Hooks.npc.name;
			this.obfuscatedName = Hooks.npc.obfuscatedName;
		}
	}

	public Actor asActor() {
		return new Actor(reference);
	}

	public int getCombatLevel() {
		return (int) getValue(getField("combatLevel"));
	}

	public NpcComposition getNpcComposition() {
		return new NpcComposition(getValue(getField("composition")));
	}
}
