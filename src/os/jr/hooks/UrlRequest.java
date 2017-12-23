package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class UrlRequest extends RSClass {

	public static String localPlayer = "localPlayer";

	public UrlRequest(Object reference) {
		super(Hooks.classNames.get("UrlRequest"));
		this.reference = reference;
	}

	public Player getLocalPlayer() {
		return new Player(getField(localPlayer).getValue(reference));
	}

}
