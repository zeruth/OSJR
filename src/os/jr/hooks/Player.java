package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Player extends GameClass {
	
	public final String PLAYER_NAME = "Player_Name";

	public Player() {
		super("bw");
		String player = "bw";
		this.fields.put("Player_Name", new GameField("d", player));
		this.fields.put("Player_Model", new GameField("y", player));
		this.fields.put("Player_Visible", new GameField("q", player));
		this.fields.put("Player_Definition", new GameField("x", player));
		this.fields.put("Player_CombatLevel", new GameField("b", player, -1374409013));
	}

	public Player(Object reference) {
		super("bw");
		String player = "bw";
		this.reference = reference;
		this.fields.put("Player_Name", new GameField("d", player));
		this.fields.put("Player_Model", new GameField("y", player));
		this.fields.put("Player_Visible", new GameField("q", player));
		this.fields.put("Player_Definition", new GameField("x", player));
		this.fields.put("Player_CombatLevel", new GameField("b", player, -1374409013));
	}
	
	public Actor asActor() {
		return new Actor(reference);
	}
	
	public String getName() {
		return (String)fields.get(PLAYER_NAME).getValue(reference);
	}

}
