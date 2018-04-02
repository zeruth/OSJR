package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class BoundingBox3D extends RSClass {

	public BoundingBox3D(Object reference) {
		this.reference = reference;
		if (Hooks.boundingBox3D != null) {
			this.fields = Hooks.boundingBox3D.fields;
			this.name = Hooks.boundingBox3D.name;
			this.obfuscatedName = Hooks.boundingBox3D.obfuscatedName;
		}
	}

	public int getCameraPitch() {
		return (int) getValue(getField("cameraPitch"));
	}
}
