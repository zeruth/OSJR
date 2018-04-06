package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import game.LoaderWindow;
import game.Settings;
import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.Npc;
import hooks.accessors.Player;
import hooks.helpers.LocalPoint;
import hooks.helpers.Perspective;
import hooks.helpers.Point;

public class ActorNames implements PaintListener {

	public static Color npcNameColor = Color.CYAN;
	public static Color playerNameColor = Color.green;
	public static Color clanMateNameColor = Color.ORANGE;

	Graphics2D g2d;

	RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
			RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

	public ActorNames(Client game) {

	}

	@Override
	public void onRepaint(Graphics g) {
		if (Settings.SHOW_PLAYER_NAMES) {
			if (this.g2d == null)
				this.g2d = (Graphics2D) g;
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					g.setColor(playerNameColor);
					Player[] ps = Hooks.client.getCachedPlayers();
					for (Player pl : ps) {
						if (pl != null) {
							if (pl.isInClanChat()) {
								Image rank = getRankImage(pl.getClanRank());
								g.setColor(clanMateNameColor);
								String name = pl.getNames().getOriginalName();
								Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
										new LocalPoint(pl.asActor().getX(), pl.asActor().getY()), name, 200);
								if (p != null) {
									g.drawString(name, p.getX(), p.getY());
									if (rank != null) {
										Graphics2D g2 = (Graphics2D) g;
										g2.setRenderingHints(this.rh);
										g2.drawImage(rank, p.getX() - 12, p.getY() - 9, LoaderWindow.game);
									}
									g.setColor(playerNameColor);
								}
							} else {
								String name = pl.getNames().getOriginalName();
								Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
										new LocalPoint(pl.asActor().getX(), pl.asActor().getY()), name, 200);
								if (p != null) {
									g.drawString(name, p.getX(), p.getY());
								}
							}

							// g2.drawImage(rank, null, p.getX(), p.getY());
						}
					}
				}

			g.setColor(npcNameColor);
			Npc[] ns = Hooks.client.getCachedNpcs();
			if (ns != null) {
				for (Npc pl : ns) {
					if (pl != null) {
						String name = pl.getNpcComposition().getName();
						if (name != null) {
							if (!name.contains("Fishing")) {
								Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
										new LocalPoint(pl.asActor().getX(), pl.asActor().getY()), name, 190);
								if (p != null && name != null && name.compareTo("null") != 0) //$NON-NLS-1$
									g.drawString(name, p.getX(), p.getY());
							}
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("resource")
	public static Image getRankImage(int clanRank) {
		String imageName = "";
		switch (clanRank) {
		case -1:
			return null;
		case 0:
			imageName = "Friend";
			break;
		case 1:
			imageName = "Recruit";
			break;
		case 2:
			imageName = "Corporal";
			break;
		case 3:
			imageName = "Sergeant";
			break;
		case 4:
			imageName = "Lieutenant";
			break;
		case 5:
			imageName = "Captain";
			break;
		case 6:
			imageName = "General";
			break;
		case 7:
			imageName = "Owner";
			break;
		}
		InputStream is = null;
		try {
			is = new FileInputStream("./resources/clan_ranks/" + imageName + ".png");
			Image rank = ImageIO.read(is);
			is.close();
			if (rank != null)
				return rank;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
