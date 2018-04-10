package paint.skills;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.util.Collection;
import game.Game;
import game.Settings;
import hooks.accessors.Client;
import hooks.accessors.DecorativeObject;
import hooks.accessors.GameObject;
import hooks.accessors.GroundObject;
import hooks.helpers.ObjectManager;
import paint.PaintListener;

public class AgilityOverlay implements PaintListener {

	Graphics2D g2;
	Area a;

	public AgilityOverlay() {
	}

	@Override
	public void onRepaint(Graphics g) {
		g.setFont(Game.runescapeFont);
		Color outlineColor = ObjectManager.outlineColor;
		Color fillColor = ObjectManager.fillColor;
		g.setColor(outlineColor);
		if (Settings.SHOW_AGILITY_OVERLAY == true) {
			if (ObjectManager.gameObjects != null)
				try {
					Collection<GameObject> gos = ObjectManager.gameObjects.values();
					for (GameObject go : gos) {
						if (go.getPlane() != Client.getPlane())
							continue;
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
								// Canifis course;
							case 10819:
							case 10820:
							case 10821:
							case 10822:
							case 10823:
							case 10828:
							case 10831:
							case 10832:
								// Falador
							case 10836:
							case 11161:
							case 11360:
							case 11361:
							case 11365:
							case 11366:
							case 11367:
							case 11369:
							case 11370:
							case 11371:
								// Seers
							case 11374:
							case 11375:
							case 11376:
							case 11377:

								g.setColor(outlineColor);
								;
								this.g2 = (Graphics2D) g;
								this.a = go.getClickbox();
								if (this.a != null) {
									this.g2.draw(this.a);
									this.g2.setPaint(fillColor);
									this.g2.fill(this.a);
								}
							}
						}
					}

					for (DecorativeObject d : ObjectManager.decorativeObjects.values()) {

						if (d != null) {
							switch (d.getID()) {

							// Al Kharid course
							case 10093:
							case 10094:
								// Varrock course
							case 10586:
								// Falador course;
							case 10833:
								// Seers course
							case 11373:
								if (d.getPlane() != Client.getPlane()) {
									if (Game.debug)
										System.out.println("" + d.getPlane() + " " + Client.getPlane()); //$NON-NLS-1$ //$NON-NLS-2$
								} else {
									g.setColor(outlineColor);
									;
									this.g2 = (Graphics2D) g;
									this.a = d.getClickbox();
									if (this.a != null) {

										this.g2.draw(this.a);
										this.g2.setPaint(fillColor);
										this.g2.fill(this.a);
									}

								}
							}

						}

					}

					for (GroundObject go : ObjectManager.groundObjects.values()) {
						if (go != null) {
							switch (go.getID()) {

							// Al Kharid Course
							case 10284:
							case 10527:
							case 10583:
							case 10584:

								// Falador course
							case 10834:
							case 11364:

								// Seers
							case 11378:
								if (go.getPlane() != Client.getPlane()) {
									if (Game.debug)
										System.out.println("" + go.getPlane() + " " + Client.getPlane());
									continue;
								}
								g.setColor(outlineColor);
								;
								this.g2 = (Graphics2D) g;
								this.a = go.getClickbox();
								if (this.a != null) {
									this.g2.draw(this.a);
									this.g2.setPaint(fillColor);
									this.g2.fill(this.a);
								}
							}
						}
					}
				} catch (Exception e) {
					ObjectManager.resetObjects();
				}
		}
	}

}
