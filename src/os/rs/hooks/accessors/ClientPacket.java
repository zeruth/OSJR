package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.model.RSClass;

public class ClientPacket extends RSClass {

	public ClientPacket(Object reference) {
		this.reference = reference;
		if (Hooks.sequence != null) {
			this.fields = Hooks.sequence.fields;
			this.name = Hooks.sequence.name;
			this.obfuscatedName = Hooks.sequence.obfuscatedName;
		}
	}

	public int getCameraYaw() {
		return (int) getValue(getField("cameraYaw"));
	}
}
