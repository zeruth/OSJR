package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class GrandExchangeOffer extends RSClass {

	public int plane = 0;

	public GrandExchangeOffer(Object reference) {
		this.reference = reference;
		if (Hooks.grandExchangeOffer != null) {
			this.fields = Hooks.grandExchangeOffer.fields;
			this.name = Hooks.grandExchangeOffer.name;
			this.obfuscatedName = Hooks.grandExchangeOffer.obfuscatedName;
		}
	}

	public int getCameraPitch() {
		return (int) getValue(getField("cameraPitch"));
	}
}
