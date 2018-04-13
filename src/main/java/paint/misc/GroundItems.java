package paint.misc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import cache.TileListener;
import game.Settings;
import hooks.Hooks;
import hooks.accessors.Item;
import hooks.accessors.ItemLayer;
import hooks.helpers.LocalPoint;
import hooks.helpers.Perspective;
import hooks.helpers.Point;
import paint.PaintListener;

public class GroundItems implements PaintListener {

	public static Color npcNameColor = Color.CYAN;
	public static Color playerNameColor = Color.green;
	public static Color clanMateNameColor = Color.ORANGE;

	Graphics2D g2d;

	RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
			RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

	public GroundItems() {

	}

	@Override
	public void onRepaint(Graphics g) {
		if (Settings.SHOW_PLAYER_NAMES) {
			if (this.g2d == null)
				this.g2d = (Graphics2D) g;
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					for (ItemLayer il : TileListener.groundItems) {
						Item item = il.getBottom();
						String name = ""+item.getId();
						Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
								new LocalPoint(il.getX(), il.getY()), name, 0);
						if (p != null) {
							g.drawString(name, p.getX(), p.getY());
						}
					}
				}
		}
	}

}
