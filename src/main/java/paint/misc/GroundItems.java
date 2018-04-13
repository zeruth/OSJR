package paint.misc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import cache.ItemDefinitionManager;
import cache.TileListener;
import game.Game;
import game.Settings;
import hooks.Hooks;
import hooks.accessors.Item;
import hooks.accessors.ItemLayer;
import hooks.helpers.LocalPoint;
import hooks.helpers.Perspective;
import hooks.helpers.Point;
import paint.PaintListener;

public class GroundItems implements PaintListener {
	Graphics2D g2d;

	RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
			RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

	public GroundItems() {

	}

	@Override
	public void onRepaint(Graphics g) {
		if (Settings.SHOW_PLAYER_NAMES && Game.ctrlPressed==false) {
			if (this.g2d == null)
				this.g2d = (Graphics2D) g;
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					for (ItemLayer il : TileListener.groundItems) {
						int i = 0;
						g.setColor(Color.white);
						Item item = il.getTop();
						if (item.reference != null) {
							String name = ItemDefinitionManager.itemDefinitions[item.getId()].getName();
							Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
									new LocalPoint(il.getX(), il.getY()), name, i);
							if (p != null) {
								g.drawString(name, p.getX(), p.getY() - i);
							}
							i += 10;
						}
						item = il.getMiddle();
						if (item.reference != null) {
							String name = ItemDefinitionManager.itemDefinitions[item.getId()].getName();
							Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
									new LocalPoint(il.getX(), il.getY()), name, i);
							if (p != null) {
								g.drawString(name, p.getX(), p.getY() - i);
							}
							i += 10;
						}
						item = il.getBottom();
						if (item.reference != null) {
							String name = ItemDefinitionManager.itemDefinitions[item.getId()].getName();
							Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
									new LocalPoint(il.getX(), il.getY()), name, i);
							if (p != null) {
								g.drawString(name, p.getX(), p.getY() - i);
							}
							i += 10;
						}
					}
				}
		}
	}

}
