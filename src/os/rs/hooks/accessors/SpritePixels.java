package os.rs.hooks.accessors;

import os.rs.hooks.Hooks;
import os.rs.hooks.model.RSClass;

public class SpritePixels extends RSClass {

	public SpritePixels(Object reference) {
		this.reference = reference;
		if (Hooks.spritePixels != null) {
			this.fields = Hooks.spritePixels.fields;
			this.name = Hooks.spritePixels.name;
			this.obfuscatedName = Hooks.spritePixels.obfuscatedName;
		}
	}

	public int getHeight() {
		return (int) getValue(getField("height"));
	}

	public int getWidth() {
		return (int) getValue(getField("width"));
	}

}
