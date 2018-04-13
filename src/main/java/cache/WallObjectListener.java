package cache;

import java.awt.Graphics;
import java.util.HashMap;

import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.Tile;
import hooks.accessors.WallObject;
import paint.PaintListener;

public class WallObjectListener implements PaintListener {
	private int tick;
	public static HashMap<Integer, WallObject> wallObjects = new HashMap<>();

	@Override
	public void onRepaint(Graphics g) {
		if (this.tick > 40) {
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					wallObjects = new HashMap<>();
					for (Tile t : Client.getRegion().getTiles()) {
						if (t.getDecorativeObject() != null) {
							WallObject wallObj = t.getWallObject();
							if (wallObj != null) {
								wallObjects.put(wallObj.getID(), wallObj);
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
