package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.helpers.Perspective;
import os.rs.hooks.model.RSClass;

public class DecorativeObject extends RSClass {

	public DecorativeObject(Object reference) {
		this.reference = reference;
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
		return (int) getValue(getField("plane"));
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
