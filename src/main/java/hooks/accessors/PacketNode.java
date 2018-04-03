package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class PacketNode extends RSClass {

	public PacketNode(Object reference) {
		this.reference = reference;
		if (Hooks.packetNode != null) {
			this.fields = Hooks.packetNode.fields;
			this.name = Hooks.packetNode.name;
			this.obfuscatedName = Hooks.packetNode.obfuscatedName;
		}
	}

	public int getBaseX() {
		return (int) getValue(getField("baseX"));
	}

}
