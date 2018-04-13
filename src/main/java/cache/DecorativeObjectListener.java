package cache;

import java.awt.Graphics;
import java.util.HashMap;

import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.DecorativeObject;
import hooks.accessors.Tile;
import paint.PaintListener;

public class DecorativeObjectListener implements PaintListener {
	private int tick;
	public static HashMap<Integer, DecorativeObject> decorativeObjects = new HashMap<>();

	@Override
	public void onRepaint(Graphics g) {
		if (this.tick > 40) {
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					decorativeObjects = new HashMap<>();
					for (Tile t : Client.getRegion().getTiles()) {
						if (t.getDecorativeObject() != null) {
							DecorativeObject decObj = t.getDecorativeObject();
							if (decObj != null) {
								decorativeObjects.put(decObj.getID(), decObj);
							}
						}
					}

				}
			this.tick = 0;
		} else {
			this.tick++;
		}

	}

}
