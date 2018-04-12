package hooks.accessors;

import hooks.Hooks;
import hooks.helpers.Perspective;
import hooks.model.RSClass;

public class GameObject extends RSClass {

	int cameraZ;
	int x;
	int y;
	int id;
	int plane;
	Renderable renderable1;
	Model model;
	java.awt.geom.Area clickbox;

	public GameObject(Object reference) {
		this.reference = reference;
		if (Hooks.gameObject != null) {
			this.fields = Hooks.gameObject.fields;
			this.name = Hooks.gameObject.name;
			this.obfuscatedName = Hooks.gameObject.obfuscatedName;
		}
	}

	public GameObject() {
		this.reference = null;
		if (Hooks.gameObject != null) {
			this.fields = Hooks.gameObject.fields;
			this.name = Hooks.gameObject.name;
			this.obfuscatedName = Hooks.gameObject.obfuscatedName;
		}
	}

	public java.awt.geom.Area getClickbox() {
		this.clickbox = Perspective.getClickbox(Hooks.client, getModel(), 0, getX(), getY());
		return this.clickbox;
	}

	public int getHash() {
		this.id = (int) getValue(getField("hash"));
		return this.id;
	}

	public int getID() {
		this.id = getHash();
		return this.id >> 14 & 32767;
	}

	public Model getModel() {
		if (this.renderable1.reference != null) {
			this.model = new Model(getValue(getField("renderable")));
			return this.model;
		}
		return null;

	}

	public int getPlane() {
		this.plane = (int) getValue(getField("plane"));
		return this.plane;
	}

	public Renderable getRenderable1() {
		this.renderable1 = new Renderable(getValue(getField("renderable")));
		return this.renderable1;
	}

	public int getX() {
		this.x = (int) getValue(getField("x"));
		return this.x;
	}

	public int getY() {
		this.y = (int) getValue(getField("y"));
		return this.y;
	}

	public int getCameraZ() {
		this.cameraZ = (int) getValue(getField("cameraZ"));
		return this.cameraZ;
	}

}
