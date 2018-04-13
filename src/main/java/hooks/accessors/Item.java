package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Item extends RSClass {

	public Item(Object reference) {
		this.reference = reference;
		if (Hooks.item != null) {
			this.fields = Hooks.item.fields;
			this.name = Hooks.item.name;
			this.obfuscatedName = Hooks.item.obfuscatedName;
		}
	}
	
	public int getId() {
		return (int) getValue(getField("id"));
	}
	public int getX() {
		return (int) getValue(getField("quantity"));
	}

}
