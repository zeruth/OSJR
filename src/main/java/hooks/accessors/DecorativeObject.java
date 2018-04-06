package hooks.accessors;

import hooks.Hooks;
import hooks.helpers.Perspective;
import hooks.model.RSClass;

public class DecorativeObject extends RSClass {

	public int plane = 0;

	public DecorativeObject(Object reference) {
		this.reference = reference;
		if (Hooks.decorativeObject != null) {
			this.fields = Hooks.decorativeObject.fields;
			this.name = Hooks.decorativeObject.name;
			this.obfuscatedName = Hooks.decorativeObject.obfuscatedName;
		}
	}

	public DecorativeObject() {
		this.reference = null;
		if (Hooks.decorativeObject != null) {
			this.fields = Hooks.decorativeObject.fields;
			this.name = Hooks.decorativeObject.name;
			this.obfuscatedName = Hooks.decorativeObject.obfuscatedName;
		}
	}

	public java.awt.geom.Area getClickbox() {
		return Perspective.getClickbox(Hooks.client, getModel(), getOrientation(), getX(), getY());
	}

	public int getHash() {
		return (int) getValue(getField("hash"));
	}

	public int getID() {
		return getHash() >> 14 & 32767;
	}

	public Model getModel() {
		if (getRenderable1().reference != null) {
			return new Model(getValue(getField("renderable1")));
		}
		return null;

	}

	public int getOrientation() {
		return (int) getValue(getField("rotation"));
	}

	public int getPlane() {
		return this.plane;
	}

	public Renderable getRenderable1() {
		return new Renderable(getValue(getField("renderable1")));
	}

	public int getX() {
		return (int) getValue(getField("x"));
	}

	public int getY() {
		return (int) getValue(getField("y"));
	}

}
