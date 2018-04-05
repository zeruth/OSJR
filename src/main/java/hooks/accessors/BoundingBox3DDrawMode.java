package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class BoundingBox3DDrawMode extends RSClass {

	public BoundingBox3DDrawMode(Object reference) {
		this.reference = reference;
		if (Hooks.boundingBox3D != null) {
			this.fields = Hooks.boundingBox3D.fields;
			this.name = Hooks.boundingBox3D.name;
			this.obfuscatedName = Hooks.boundingBox3D.obfuscatedName;
		}
	}
	
	public int getPlane() {
		return (int) getValue(getField("plane"));
	}
}
