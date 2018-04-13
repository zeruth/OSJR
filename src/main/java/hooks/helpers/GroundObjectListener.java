package hooks.helpers;

import java.awt.Graphics;
import java.util.HashMap;

import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.GroundObject;
import hooks.accessors.Tile;
import paint.PaintListener;

public class GroundObjectListener implements PaintListener {
	private int tick = 0;
	public static HashMap<Integer, GroundObject> groundObjects = new HashMap<>();

	@Override
	public void onRepaint(Graphics g) {
		if (this.tick > 40) {
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					for (Tile t : Client.getRegion().getTiles()) {
						if (t.getGroundObject() != null) {
							GroundObject groundObj = t.getGroundObject();
							if (groundObj != null) {
								groundObjects.put(groundObj.getID(), groundObj);
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
