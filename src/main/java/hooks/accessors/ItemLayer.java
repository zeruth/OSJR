package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class ItemLayer extends RSClass {

	public ItemLayer(Object reference) {
		this.reference = reference;
		if (Hooks.itemLayer != null) {
			this.fields = Hooks.itemLayer.fields;
			this.name = Hooks.itemLayer.name;
			this.obfuscatedName = Hooks.itemLayer.obfuscatedName;
		}
	}

	public int getHash() {
		return (int) getValue(getField("hash"));
	}

	public int getX() {
		return (int) getValue(getField("x"));
	}

	public int getY() {
		return (int) getValue(getField("y"));
	}

	public Item getBottom() {
		return new Item(getValue(getField("bottom")));
	}

	public Item getMiddle() {
		return new Item(getValue(getField("middle")));
	}

	public Item getTop() {
		return new Item(getValue(getField("top")));
	}
}
