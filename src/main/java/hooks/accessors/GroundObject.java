package hooks.accessors;

import hooks.Hooks;
import hooks.helpers.Perspective;
import hooks.model.RSClass;

public class GroundObject extends RSClass {

	public int plane = 0;

	public GroundObject(Object reference) {
		this.reference = reference;
		if (Hooks.groundObject != null) {
			this.fields = Hooks.groundObject.fields;
			this.name = Hooks.groundObject.name;
			this.obfuscatedName = Hooks.groundObject.obfuscatedName;
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
		return plane;
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

}
