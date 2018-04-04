package paint.agility;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Collection;
import javax.imageio.ImageIO;

import java.awt.Shape;

import game.Game;
import game.LoaderWindow;
import game.OSRSLauncher;
import game.Settings;
import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.DecorativeObject;
import hooks.accessors.GameObject;
import hooks.accessors.GroundObject;
import hooks.helpers.ObjectManager;
import hooks.helpers.Skill;
import paint.listeners.PaintListener;

public class AgilityOverlay implements PaintListener {

	Graphics2D g2;
	Area a;
	public static Color fillColor = new Color(Color.YELLOW.getBlue(), Color.YELLOW.getGreen(), Color.YELLOW.getRed(), 50);
	public static Color outlineColor = Color.YELLOW;

	public AgilityOverlay(Client game) {
	}

	@SuppressWarnings("resource")
	@Override
	public void onRepaint(Graphics g) {
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
								//Seers
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
									this.g2.setPaint(AgilityOverlay.fillColor);
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
										this.g2.setPaint(AgilityOverlay.fillColor);
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
								
								//Seers
							case 11378:
								if (go.getPlane() != Client.getPlane()) {
									if (Game.debug)
										System.out.println("" + go.getPlane() + " " + Client.getPlane()); //$NON-NLS-1$ //$NON-NLS-2$
									continue;
								}
								g.setColor(outlineColor);
								;
								this.g2 = (Graphics2D) g;
								this.a = go.getClickbox();
								if (this.a != null) {
									this.g2.draw(this.a);
									this.g2.setPaint(AgilityOverlay.fillColor);
									this.g2.fill(this.a);
								}
							}
						}
					}
				} catch (Exception e) {
					ObjectManager.resetObjects();
				}

			if (OSRSLauncher.loaderWindow.getWidth() <= 850) {
				RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				int radiusX = 50;
				int centerX = ((OSRSLauncher.loaderWindow.getWidth() - (radiusX)) / 2) - 50;
				int centerY = 5;
				int radiusYY = 50;
				int startAngle = 90;
				Shape circle = new Ellipse2D.Double(centerX, centerY, radiusYY, radiusX);
				Graphics2D g22 = (Graphics2D) g;
				g.setColor(Color.DARK_GRAY.darker());
				g22.setRenderingHints(rh);
				g22.setStroke(new BasicStroke(3));
				g22.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 15));
				g22.setColor(AgilityOverlay.fillColor);
				InputStream is = null;
				try {
					is = new FileInputStream("./resources/skill_icons/" + "Agility" + ".png");
					Image skillIcon = ImageIO.read(is);
					is.close();
					this.g2.drawImage(skillIcon, centerX - 18, centerY + 13, LoaderWindow.game);
				} catch (Exception e) {
					e.printStackTrace();
				}
				g22.fill(circle);
				g.setColor(outlineColor);
				int lvl = Hooks.client.getRealSkillLevels()[16];
				double percentage = Skill.getLevelUpPercentage(16);
				DecimalFormat df = new DecimalFormat("##.##");
				g22.drawString(Integer.toString(lvl), centerX + 16, 20);
				String s = (String) "-" + (int) ((percentage / 100) * 360);
				int length = Integer.valueOf(s);
				g22.drawArc(centerX, centerY, radiusX, radiusYY, startAngle, length);
				g22.setFont(new Font("TimesRoman", Font.PLAIN, 24));
				String i = String.valueOf((int) percentage);
				if ((int) percentage < 10) {
					i = "0" + i;
				}
				g22.drawString("" + i, centerX + 6, 40);
				g22.setFont(new Font("TimesRoman", Font.BOLD, 14));
				String percentage2 = "";
				if (df.format(percentage).split("\\.").length == 2) {
					percentage2 = df.format(percentage).split("\\.")[1];
					if (percentage2.length() == 1)
						percentage2 = percentage2 + 0;
				} else {
					percentage2 = "00";
				}
				g22.drawString("." + percentage2, centerX + 28, 40);
				g.setColor(AgilityOverlay.fillColor);
				g22.setStroke(new BasicStroke());
			} else {
				RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				int radiusX = 50;
				int centerX = ((OSRSLauncher.loaderWindow.getWidth() - (radiusX)) / 2) - 50;
				int centerY = 5;
				int radiusYY = 50;
				int startAngle = 90;
				Shape circle = new Ellipse2D.Double(centerX, centerY, radiusYY, radiusX);
				Graphics2D g22 = (Graphics2D) g;
				g.setColor(Color.DARK_GRAY.darker());
				g22.setRenderingHints(rh);
				g22.setStroke(new BasicStroke(3));
				g22.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 15));
				g22.setColor(AgilityOverlay.fillColor);
				InputStream is = null;
				try {
					is = new FileInputStream("./resources/skill_icons/" + "Agility" + ".png");
					Image skillIcon = ImageIO.read(is);
					is.close();
					this.g2.drawImage(skillIcon, centerX - 18, centerY + 13, LoaderWindow.game);
				} catch (Exception e) {
					e.printStackTrace();
				}
				g22.fill(circle);
				g.setColor(outlineColor);
				int lvl = Hooks.client.getRealSkillLevels()[16];
				double percentage = Skill.getLevelUpPercentage(16);
				DecimalFormat df = new DecimalFormat("##.##");
				g22.drawString(Integer.toString(lvl), centerX + 16, 20);
				String s = (String) "-" + (int) ((percentage / 100) * 360);
				int length = Integer.valueOf(s);
				g22.drawArc(centerX, centerY, radiusX, radiusYY, startAngle, length);
				g22.setFont(new Font("TimesRoman", Font.PLAIN, 24));
				String i = String.valueOf((int) percentage);
				if ((int) percentage < 10) {
					i = "0" + i;
				}
				g22.drawString("" + i, centerX + 6, 40);
				g22.setFont(new Font("TimesRoman", Font.BOLD, 14));
				String percentage2 = "";
				if (df.format(percentage).split("\\.").length == 2) {
					percentage2 = df.format(percentage).split("\\.")[1];
					if (percentage2.length() == 1)
						percentage2 = percentage2 + 0;
				} else {
					percentage2 = "00";
				}
				g22.drawString("." + percentage2, centerX + 28, 40);
				g.setColor(AgilityOverlay.fillColor);
				g22.setStroke(new BasicStroke());
			}

		}
	}

}
