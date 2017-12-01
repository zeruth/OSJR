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

}
