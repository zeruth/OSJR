package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.model.RSClass;

public class PacketNode extends RSClass {

	public PacketNode(Object reference) {
		this.reference = reference;
		if (Hooks.packetNode != null) {
			fields = Hooks.packetNode.fields;
			name = Hooks.packetNode.name;
			obfuscatedName = Hooks.packetNode.obfuscatedName;
		}
	}

	public int getBaseX() {
		return (int) getValue(getField("baseX"));
	}

}
