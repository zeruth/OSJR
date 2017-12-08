package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Player extends GameClass {

	public static final String player = "bj";
	public static final String field_Name = "a";
	public static final String field_Model = "y";
	public static final String field_Visible = "m";
	public static final String field_Definition = "w";
	public static final String field_CombatLevel = "t";

	public static final int field_CombatLevel_multiplier = 959498037;

	public final String PLAYER_NAME = "Player_Name";
	public final String PLAYER_MODEL = "Player_Model";
	public final String PLAYER_VISIBLE = "Player_Visible";
	public final String PLAYER_DEFINITION = "Player_Definition";
	public final String PLAYER_COMBAT_LEVEL = "Player_CombatLevel";

	public Player() {
		super(player);
		this.fields.put("Player_Name", new GameField(field_Name, player));
		this.fields.put("Player_Model", new GameField(field_Model, player));
		this.fields.put("Player_Visible", new GameField(field_Visible, player));
		this.fields.put("Player_Definition", new GameField(field_Definition, player));
		this.fields.put("Player_CombatLevel", new GameField(field_CombatLevel, player, field_CombatLevel_multiplier));
	}

	public Player(Object reference) {
		super(player);
		this.reference = reference;
		this.fields.put("Player_Name", new GameField(field_Name, player));
		this.fields.put("Player_Model", new GameField(field_Model, player));
		this.fields.put("Player_Visible", new GameField(field_Visible, player));
		this.fields.put("Player_Definition", new GameField(field_Definition, player));
		this.fields.put("Player_CombatLevel", new GameField(field_CombatLevel, player, field_CombatLevel_multiplier));
	}

	public Actor asActor() {
		return new Actor(reference);
	}

	public String getName() {
		return (String) fields.get(PLAYER_NAME).getValue(reference);
	}
	
	public int getModel() {
		return (int) fields.get(PLAYER_MODEL).getValue(reference);
	}
	
	public boolean getVisible() {
		return (boolean) fields.get(PLAYER_VISIBLE).getValue(reference);
	}
	
	public PlayerDefinition getPlayerDefinition() {
		return new PlayerDefinition(fields.get(PLAYER_DEFINITION).getValue(reference));
	}

}
