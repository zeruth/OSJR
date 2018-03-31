package os.rs.paint.listeners;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import os.rs.game.Settings;
import os.rs.hooks.Hooks;
import os.rs.hooks.accessors.Client;
import os.rs.hooks.accessors.Tile;
import os.rs.hooks.accessors.WallObject;
import os.rs.hooks.helpers.LocalPoint;
import os.rs.hooks.helpers.Perspective;
import os.rs.hooks.helpers.Point;

public class WallObjects implements PaintListener {

	public WallObjects(Client game) {
	}

	@Override
	public void onRepaint(Graphics g) {
		g.setColor(Color.yellow);
		if (Settings.SHOW_WALLOBJECT_IDS)
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					for (Tile t : Hooks.client.getRegion().getTiles()) {
						WallObject wo = t.getWallObject();
						if (wo != null) {
							String name = "" + wo.getID() + "p: " + 0 + " x:" + wo.getX() + " y:" + wo.getY();
							Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
									new LocalPoint(wo.getX(), wo.getY()), name, 0);
							if (p != null && name != null && name.compareTo("null") != 0)
								g.drawString(name, p.getX(), p.getY());
						}
					}
				}

	}

}
