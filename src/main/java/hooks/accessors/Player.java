package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Player extends RSClass {
	
	int cameraX;

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

	public boolean isInClanChat() {
		try {
			if (Client.getClanMemberManager().reference != null) {
				for (Nameable n : Client.getClanMemberManager().asNameableContainer().getNameables()) {
					if (n != null) {
						if (n.getName().getOriginalName().compareTo(getNames().getOriginalName()) == 0)
							return true;
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getClanRank() {
		if (isInClanChat()) {
			for (Nameable n : Client.getClanMemberManager().asNameableContainer().getNameables()) {
				if (n != null) {
					if (n.getName().getOriginalName().compareTo(getNames().getOriginalName()) == 0)
						return n.asClanMember().asChatPlayer().getRank();
				}
			}
		}
		return 0;
	}

	public int getCameraX() {
		this.cameraX = (int) getValue(getField("cameraX"));
		return this.cameraX;
	}
}
