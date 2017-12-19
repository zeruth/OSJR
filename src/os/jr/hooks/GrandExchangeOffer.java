package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class GrandExchangeOffer extends GameClass{

	public GrandExchangeOffer(Object reference) {
		super(Hooks.classNames.get("GrandExchangeOffer"));
		this.reference = reference;
	}

}
