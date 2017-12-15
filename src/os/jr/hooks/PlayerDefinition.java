package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class PlayerDefinition extends GameClass {
	
	public static final String playerDefinition = "hb";
	public static final String field_ID = "k";
	public static final String field_IS_FEMALE = "e";
	public static final String field_EQUIPMENT = "a";
	
	public static final int field_ID_MULTIPLIER = 1273015549;
	
	public static final String PLAYER_DEFINITION_ID = "PlayerDefinition_ID";
	public static final String PLAYER_DEFINITION_IS_FEMALE = "PlayerDefinition_IsFemale";
	public static final String PLAYER_DEFINITION_EQUIPMENT = "PlayerDefinition_Equipment";

	public PlayerDefinition() {
		super(playerDefinition);
		this.fields.put("PlayerDefinition_ID", new GameField(field_ID, playerDefinition, field_ID_MULTIPLIER));
		this.fields.put("PlayerDefinition_IsFemale", new GameField(field_IS_FEMALE, playerDefinition));
		this.fields.put("PlayerDefinition_Equipment", new GameField(field_EQUIPMENT, playerDefinition));
	}
	
	public PlayerDefinition(Object reference) {
		super(playerDefinition);
		this.reference=reference;
		this.fields.put("PlayerDefinition_ID", new GameField(field_ID, playerDefinition, field_ID_MULTIPLIER));
		this.fields.put("PlayerDefinition_IsFemale", new GameField(field_IS_FEMALE, playerDefinition));
		this.fields.put("PlayerDefinition_Equipment", new GameField(field_EQUIPMENT, playerDefinition));
	}
	
	public int getplayerID() {
		return (int) fields.get(PLAYER_DEFINITION_ID).getValue(reference);
	}
	
	public boolean isFemale() {
		return (boolean) fields.get(PLAYER_DEFINITION_IS_FEMALE).getValue(reference);
	}

}
