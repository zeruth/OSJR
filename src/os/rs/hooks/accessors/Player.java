package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.model.RSClass;

public class Player extends RSClass {

	public Player(Object reference) {
		this.reference = reference;
		if (Hooks.player != null) {
			this.fields = Hooks.player.fields;
			this.name = Hooks.player.name;
			this.obfuscatedName = Hooks.player.obfuscatedName;
		}
	}

	public Actor asActor() {
		return new Actor(reference);
	}

	public int getCombatLevel() {
		return (int) getValue(getField("combatLevel"));
	}

	public Name getNames() {
		return new Name(getValue(getField("name")));
	}

}
