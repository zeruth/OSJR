package os.jr.game.accessors;

import os.jr.hooks.HookLoader;
import os.jr.hooks.model.RSField;

public class Actor extends RenderableNode {

	protected Actor() {
	}

	public Actor(Object actor, Client client) {
		this.obj = actor;
		this.client = client;
		this.hash = System.identityHashCode(this);
	}
	
	public CombatInfoList getCombatInfoList() {
		RSField f = HookLoader.classStorage.get("Actor").getField("Actor_CombatInfoList");
		return new CombatInfoList(f.getValue(obj), client);
	}

	public int getX() {
		RSField field = HookLoader.classStorage.get("Character").getField("getX");
		int x = (int) field.getValue(obj) * field.getMultiplier();
		return x;
	}

	public int getY() {

		RSField field = HookLoader.classStorage.get("Character").getField("getY");
		int y = (int) field.getValue(obj) * field.getMultiplier();
		return y;
	}
	/*

	public Tile getLocation() {
		int posX = client.getBaseX() + (getX() >> 7);
		int posY = client.getBaseY() + (getY() >> 7);
		return new Tile(posX, posY);
	}

*/
	public int getHealth() {
		RSField field = HookLoader.classStorage.get("Character").getField("getHealth");
		int y = (int) field.getValue(obj) * field.getMultiplier();
		return y;
	}
}
