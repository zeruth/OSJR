package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Player extends GameClass {

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

	public CombatInfoList getCombatInfoList() throws NoSuchFieldException, SecurityException, ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {
		Actor actor = Hooks.selector.actor;
		CombatInfoList cil = actor.getCombatInfoList(this.reference);
		return cil;
	}
	
	public Object getHealthScale() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		return getCombatInfoList().getCombatInfo2().getHealthScale();
	}

}
