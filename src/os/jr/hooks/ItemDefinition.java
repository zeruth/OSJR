package os.jr.hooks;

import os.jr.hooks.model.GameField;

public class ItemDefinition extends Item {

	public static final String itemDefinition = "jq";
	public static final String field_ID = "n";
	public static final String field_Name = "o";
	public static final String field_IsMembers = "ag";
	public static final String field_Actions = "ak";
	public static final String field_GroundActions = "as";

	public static final int field_ID_multiplier = 893144361;

	public ItemDefinition() {
		super(itemDefinition);
		this.fields.put("ItemDefinition_ID", new GameField(field_ID, itemDefinition, field_ID_multiplier));
		this.fields.put("ItemDefinition_Name", new GameField(field_Name, itemDefinition));
		this.fields.put("ItemDefinition_IsMembers", new GameField(field_IsMembers, itemDefinition));
		this.fields.put("ItemDefinition_Actions", new GameField(field_Actions, itemDefinition));
		this.fields.put("ItemDefinition_GroundActions", new GameField(field_GroundActions, itemDefinition));

	}

}
