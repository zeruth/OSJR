package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class ClanMember extends RSClass {
	
	ChatPlayer chatPLayer;

	public ClanMember(Object reference) {
		this.reference = reference;
		if (Hooks.clanMember != null) {
			this.fields = Hooks.clanMember.fields;
			this.name = Hooks.clanMember.name;
			this.obfuscatedName = Hooks.clanMember.obfuscatedName;
		}
	}

	public ChatPlayer asChatPlayer() {
		this.chatPLayer = new ChatPlayer(this.reference);
		return this.chatPLayer;
	}

}
