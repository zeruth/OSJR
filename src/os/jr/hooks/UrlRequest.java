package os.jr.hooks;

import os.jr.game.RSGame;
import os.jr.hooks.loader.GameClass;

public class UrlRequest extends GameClass {

	public static String localPlayer = "localPlayer";

	public UrlRequest(Object reference) {
		super(Hooks.classNames.get("UrlRequest"));
		this.reference = reference;
	}

	public Player getLocalPlayer() {

		Player p = Hooks.selector.player;
		p.reference = fields.get(localPlayer).getValue(RSGame.rootReference);
		return p;
	}

}
