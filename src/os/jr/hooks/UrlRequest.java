package os.jr.hooks;

import os.jr.boot.Boot;
import os.jr.game.RSGame;
import os.jr.hooks.model.GameClass;

public class UrlRequest extends GameClass{
	
	public static String localPlayer = "localPlayer";

	public UrlRequest() {
		super(Hooks.classNames.get("UrlRequest"));
	}
	
	public Player getLocalPlayer() {

		Player p = Hooks.selector.player;
		p.reference = fields.get(localPlayer).getValue(RSGame.rootReference);
		return p;
	}

}
