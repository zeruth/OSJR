package hooks.accessors;

import hooks.Hooks;
import hooks.helpers.Perspective;
import hooks.model.RSClass;

public class GameObject extends RSClass {

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
		return Perspective.getClickbox(Hooks.client, getModel(), 0, getX(), getY());
	}

	public int getHash() {
		return (int) getValue(getField("hash"));
	}

	public int getID() {
		int hash = getHash();
		return hash >> 14 & 32767;
	}

	public Model getModel() {
		if (getRenderable1().reference != null) {
			return new Model(getValue(getField("renderable")));
		}
		return null;

	}

	public int getPlane() {
		return (int) getValue(getField("plane"));
	}

	public Renderable getRenderable1() {
		return new Renderable(getValue(getField("renderable")));
	}

	public int getX() {
		return (int) getValue(getField("x"));
	}

	public int getY() {
		return (int) getValue(getField("y"));
	}

	public int getCameraZ() {
		return (int) getValue(getField("cameraZ"));
	}

}
