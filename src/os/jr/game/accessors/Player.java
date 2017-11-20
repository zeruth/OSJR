package os.jr.game.accessors;

import os.jr.hooks.HookLoader;
import os.jr.hooks.model.RSField;

public class Player extends Actor {

	public Player(Object player, Client client) {
		this.obj = player;
		this.client = client;
		this.hash = System.identityHashCode(this);
	}

	public String getName() {
		RSField field = HookLoader.classStorage.get("Player").getField("Player_Name");
		String name = (String) field.getValue(obj);
		return name;
	}

	public int getModel() {
		RSField field = HookLoader.classStorage.get("Player").getField("Player_Model");
		int model = (int) field.getValue(obj);
		return model;
	}
	
	public boolean isVisible() {
		RSField field = HookLoader.classStorage.get("Player").getField("Player_Visible");
		boolean visible = (boolean) field.getValue(obj);
		return visible;
	}
	
	public int getCombatLvl() {
		RSField field = HookLoader.classStorage.get("Player").getField("Player_CombatLevel");
		int cb = (int) field.getValue(obj);
		return cb;
	}

}
