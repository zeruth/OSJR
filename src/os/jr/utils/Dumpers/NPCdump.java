package os.jr.utils.Dumpers;

import os.jr.hooks.NPC;

public class NPCdump {
	
	int id;
	String name;
	String[] actions;
	int[] modelIds;
	int combatLevel;
	
	public NPCdump(NPC npc) {
		this.id = npc.getNPCDefinition().getID();
		this.name = npc.getNPCDefinition().getName();
		this.actions = npc.getNPCDefinition().getActions();
		this.modelIds = npc.getNPCDefinition().getModelIDs();
		this.combatLevel = npc.getNPCDefinition().getCombatLevel();
	}
}