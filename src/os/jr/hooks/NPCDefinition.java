package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class NPCDefinition extends GameClass {

	public static final String npcDefinition = "jn";
	public static final String field_ID = "u";
	public static final String field_Name = "z";
	public static final String field_Actions = "q";
	public static final String field_ModelIDs = "f";
	public static final String field_CombatLevel = "h";

	public static final int field_ID_multiplier = 1273015549;
	public static final int field_CombatLevel_multiplier = -280231869;

	public NPCDefinition() {
		super(npcDefinition);
		this.fields.put("NPCDefinition_ID", new GameField(field_ID, npcDefinition, field_ID_multiplier));
		this.fields.put("NPCDefinition_Name", new GameField(field_Name, npcDefinition));
		this.fields.put("NPCDefinition_Actions", new GameField(field_Actions, npcDefinition));
		this.fields.put("NPCDefinition_ModelIDs", new GameField(field_ModelIDs, npcDefinition));
		this.fields.put("NPCDefinition_CombatLevel",
				new GameField(field_CombatLevel, npcDefinition, field_CombatLevel_multiplier));
	}

}
