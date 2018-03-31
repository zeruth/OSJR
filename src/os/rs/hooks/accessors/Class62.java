package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.model.RSClass;

public class Class62 extends RSClass {

	public Class62(Object reference) {
		this.reference = reference;
		if (Hooks.class62 != null) {
			this.fields = Hooks.class62.fields;
			this.name = Hooks.class62.name;
			this.obfuscatedName = Hooks.class62.obfuscatedName;
		}
	}

	public int[][][] getTileHeights() {
		return (int[][][]) getValue(getField("tileHeights"));
	}

	public byte[][][] getTileSettings() {
		return (byte[][][]) getValue(getField("tileSettings"));
	}
}
