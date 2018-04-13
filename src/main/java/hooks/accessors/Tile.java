package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Tile extends RSClass {

	public Tile(Object reference) {
		this.reference = reference;
		if (Hooks.tile != null) {
			this.fields = Hooks.tile.fields;
			this.name = Hooks.tile.name;
			this.obfuscatedName = Hooks.tile.obfuscatedName;
		}
	}

	public DecorativeObject getDecorativeObject() {
		Object o = getValue(getField("decorativeObject"));
		if (o != null)
			return new DecorativeObject(o);
		return null;
	}

	public GroundObject getGroundObject() {
		Object o = getValue(getField("groundObject"));
		if (o != null)
			return new GroundObject(o);
		return null;
	}

	public ItemLayer getItemLayer() {
		return new ItemLayer(getValue(getField("itemLayer")));
	}

	public GameObject[] getObjects() {
		Object[] os = (Object[]) getValue(getField("objects"));
		int i = 0;
		GameObject[] gos = new GameObject[os.length];
		for (Object o : os) {
			if (o != null) {
				gos[i] = new GameObject(o);
				i++;
			}
		}
		return gos;
	}

	public int getPlane() {
		return (int) getValue(getField("plane"));
	}

	public WallObject getWallObject() {
		Object o = getValue(getField("wallObject"));
		if (o != null)
			return new WallObject(o);
		return null;
	}

	public int getX() {
		return (int) getValue(getField("x"));
	}

	public int getY() {
		return (int) getValue(getField("y"));
	}

}
