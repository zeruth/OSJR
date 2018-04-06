package hooks.accessors;

import hooks.Hooks;
import hooks.helpers.Perspective;
import hooks.model.RSClass;

public class Npc extends RSClass {

	public Model paintModel;

	public Npc(Object reference) {
		this.reference = reference;
		if (Hooks.npc != null) {
			this.fields = Hooks.npc.fields;
			this.name = Hooks.npc.name;
			this.obfuscatedName = Hooks.npc.obfuscatedName;
		}
	}

	public Actor asActor() {
		return new Actor(this.reference);
	}

	public int getCombatLevel() {
		return (int) getValue(getField("combatLevel"));
	}

	public NpcComposition getNpcComposition() {
		return new NpcComposition(getValue(getField("composition")));
	}

	public java.awt.geom.Area getClickbox() {
		if (this.paintModel != null)
			return Perspective.getClickbox(Hooks.client, this.paintModel, 0, asActor().getX(), asActor().getY());
		return null;
	}
}
