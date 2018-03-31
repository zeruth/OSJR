package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.helpers.Perspective;
import os.rs.hooks.model.RSClass;

public class GroundObject extends RSClass {

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
		return (int) getValue(getField("floor"));
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
