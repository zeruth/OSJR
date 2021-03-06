package paint.misc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import cache.TileListener;
import game.Game;
import game.Settings;
import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.DecorativeObject;
import hooks.helpers.LocalPoint;
import hooks.helpers.Perspective;
import hooks.helpers.Point;
import paint.PaintListener;

public class DecorativeObjects implements PaintListener {

	public DecorativeObjects(Client game) {
	}

	@Override
	public void onRepaint(Graphics g) {
		g.setColor(Color.yellow);
		if (Settings.SHOW_DECORATIVEOBJECT_IDS && Game.ctrlPressed==false)
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					for (DecorativeObject o : TileListener.decorativeObjects.values()) {
						String name = "" + o.getID() + "p: " + 0 + " x:" + o.getX() + " y:" + o.getY();
						Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
								new LocalPoint(o.getX(), o.getY()), name, 0);
						if (p != null && name != null && name.compareTo("null") != 0)
							g.drawString(name, p.getX(), p.getY());
					}
				}
	}

}
