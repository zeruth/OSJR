package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

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
		return new Actor(this.reference);
	}

	public int getCombatLevel() {
		return (int) getValue(getField("combatLevel"));
	}

	public Name getNames() {
		return new Name(getValue(getField("name")));
	}

}
