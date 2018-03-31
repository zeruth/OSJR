package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;

public class PlayerComposition extends Actor {

	public PlayerComposition(Object reference) {
		super(reference);
		this.reference = reference;
		if (Hooks.playerComposition != null) {
			this.fields = Hooks.playerComposition.fields;
			this.name = Hooks.playerComposition.name;
			this.obfuscatedName = Hooks.playerComposition.obfuscatedName;
		}
	}
}
