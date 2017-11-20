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

	public int getX() {
		Object cachedObject = client.getCache().get("Character#getX" + hash);
		if (cachedObject != null) {
			return (int) cachedObject;
		}

		RSField field = HookLoader.classStorage.get("Character").getField("getX");
		int x = (int) field.getValue(obj) * field.getMultiplier();

		client.getCache().put("Character#getX" + hash, x);
		return x;
	}

	public int getY() {
		Object cachedObject = client.getCache().get("Character#getY" + hash);
		if (cachedObject != null) {
			return (int) cachedObject;
		}

		RSField field = HookLoader.classStorage.get("Character").getField("getY");
		int y = (int) field.getValue(obj) * field.getMultiplier();

		client.getCache().put("Character#getY" + hash, y);
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
		Object cachedObject = client.getCache().get("Character#getHealth" + hash);
		if (cachedObject != null) {
			return (int) cachedObject;
		}

		RSField field = HookLoader.classStorage.get("Character").getField("getHealth");
		int y = (int) field.getValue(obj) * field.getMultiplier();

		client.getCache().put("Character#getHealth" + hash, y);
		return y;
	}
}
