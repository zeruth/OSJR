package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class GrandExchangeOffer extends GameClass {

	public GrandExchangeOffer(Object reference) {
		super(Hooks.classNames.get("GrandExchangeOffer"));
		this.reference = reference;
	}

}
