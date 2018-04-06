package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class ChatPlayer extends RSClass {

	public ChatPlayer(Object reference) {
		this.reference = reference;
		if (Hooks.chatPlayer != null) {
			this.fields = Hooks.chatPlayer.fields;
			this.name = Hooks.chatPlayer.name;
			this.obfuscatedName = Hooks.chatPlayer.obfuscatedName;
		}
	}

	public int getRank() {
		return (int) getValue(getField("rank"));
	}

}
