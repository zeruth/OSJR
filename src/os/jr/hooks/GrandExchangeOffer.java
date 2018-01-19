package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class GrandExchangeOffer extends RSClass {
	

	public static String localPlayer = "localPlayer";
	
	public GrandExchangeOffer(Object reference) {
		super(Hooks.classNames.get("GrandExchangeOffer"));
		this.reference = reference;
	}

	public Player getLocalPlayer() {
		return new Player(getField(localPlayer).getValue(reference));
	}
}
