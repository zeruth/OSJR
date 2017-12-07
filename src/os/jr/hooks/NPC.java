package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class NPC extends GameClass {

	public static final String npc = "ci";
	public static final String field_Definition = "a";
	
	public static final String NPC_DEFINITION = "NPC_Definition";

	public NPC() {
		super(npc);
		this.fields.put("NPC_Definition", new GameField(field_Definition, npc));
	}
	
	public NPC(Object reference) {
		super(npc);
		this.reference = reference;
		this.fields.put("NPC_Definition", new GameField(field_Definition, npc));
	}
	
	public NPCDefinition getNPCDefinition() {
		return new NPCDefinition(fields.get("NPC_Definition").getValue(reference));
	}

}
