package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class ChatPlayer extends RSClass {
	
	int rank;

	public ChatPlayer(Object reference) {
		this.reference = reference;
		if (Hooks.chatPlayer != null) {
			this.fields = Hooks.chatPlayer.fields;
			this.name = Hooks.chatPlayer.name;
			this.obfuscatedName = Hooks.chatPlayer.obfuscatedName;
		}
	}

	public int getRank() {
		this.rank = (int) getValue(getField("rank"));;
		return this.rank;
	}

}
