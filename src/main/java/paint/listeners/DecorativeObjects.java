package paint.listeners;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import game.Settings;
import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.DecorativeObject;
import hooks.accessors.Tile;
import hooks.helpers.LocalPoint;
import hooks.helpers.Perspective;
import hooks.helpers.Point;

public class DecorativeObjects implements PaintListener {

	public DecorativeObjects(Client game) {
	}

	@Override
	public void onRepaint(Graphics g) {
		g.setColor(Color.yellow);
		if (Settings.SHOW_DECORATIVEOBJECT_IDS)
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					for (Tile t : Hooks.client.getRegion().getTiles()) {
						if (t.getDecorativeObject() != null) {
							DecorativeObject o = t.getDecorativeObject();
							String name = "" + t.getDecorativeObject().getID() + "p: " + 0 + " x:" + o.getX() + " y:"
									+ o.getY();
							Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
									new LocalPoint(o.getX(), o.getY()), name, 0);
							if (p != null && name != null && name.compareTo("null") != 0)
								g.drawString(name, p.getX(), p.getY());
						}
					}
				}
	}

}
