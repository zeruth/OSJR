package os.rs.paint.agility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;

import os.rs.game.Settings;
import os.rs.hooks.Hooks;
import os.rs.hooks.accessors.Client;
import os.rs.hooks.accessors.GameObject;
import os.rs.hooks.accessors.Tile;
import os.rs.paint.listeners.PaintListener;

public class AgilityOverlay implements PaintListener {

	public AgilityOverlay(Client game) {
	}

	@Override
	public void onRepaint(Graphics g) {
		g.setColor(Color.YELLOW);
		if (Settings.SHOW_AGILITY_OVERLAY == true) {
			for (Tile t : Hooks.client.getRegion().getTiles()) {
				if (t != null) {
					if (t.getDecorativeObject() != null)
						switch (t.getDecorativeObject().getID()) {

						// Al Kharid course
						case 10093:
						case 10094:
							// Varrock course
						case 10586:
							g.setColor(Color.YELLOW);
							;
							Graphics2D g2 = (Graphics2D) g;
							Area a = t.getDecorativeObject().getClickbox();
							if (a != null) {
								g2.draw(a);
								Color c = new Color(Color.YELLOW.getBlue(), Color.YELLOW.getGreen(),
										Color.YELLOW.getRed(), 50);
								g2.setPaint(c);
								g2.fill(a);
							}
						}
					if (t.getGroundObject() != null)
						switch (t.getGroundObject().getID()) {
						// Al Kharid Course
						case 10284:
						case 10527:
						case 10583:
						case 10584:
							g.setColor(Color.YELLOW);
							;
							Graphics2D g2 = (Graphics2D) g;
							if (t.getGroundObject() != null) {
								Area a = t.getGroundObject().getClickbox();
								if (a != null) {
									g2.draw(a);
									Color c = new Color(Color.YELLOW.getBlue(), Color.YELLOW.getGreen(),
											Color.YELLOW.getRed(), 50);
									g2.setPaint(c);
									g2.fill(a);
								}
							}
						}
					for (GameObject go : t.getObjects()) {
						if (go != null) {
							switch (go.getID()) {

							// Al Kharid course
							case 10355:
							case 10357:
							case 10352:
								// Varrock course
							case 10587:
							case 10642:
							case 10777:
							case 10778:
							case 10779:
							case 10780:
							case 10781:
							case 10817:
								g.setColor(Color.YELLOW);
								;
								Graphics2D g2 = (Graphics2D) g;
								Area a = go.getClickbox();
								if (a != null) {
									g2.draw(a);
									Color c = new Color(Color.YELLOW.getBlue(), Color.YELLOW.getGreen(),
											Color.YELLOW.getRed(), 50);
									g2.setPaint(c);
									g2.fill(a);
								}
							}
						}
					}
					// System.out.println(Hooks.client.getLocalPlayer().asActor().getX());
					// System.out.println(Hooks.client.getLocalPlayer().asActor().getY());
					// Tile tt =
					// Hooks.client.getRegion().getTile(Hooks.client.getLocalPlayer().asActor().getX(),
					// Hooks.client.getLocalPlayer().asActor().getY());
				}
			}

		}

	}

}
