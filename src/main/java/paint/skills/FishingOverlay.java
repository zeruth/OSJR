package paint.skills;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import game.Game;
import game.Settings;
import hooks.Hooks;
import hooks.accessors.Npc;
import hooks.helpers.LocalPoint;
import hooks.helpers.ObjectManager;
import hooks.helpers.Perspective;
import hooks.helpers.Point;
import paint.ActorNames;
import paint.PaintListener;

public class FishingOverlay implements PaintListener {

	Graphics2D g2d;

	public FishingOverlay() {

	}

	@Override
	public void onRepaint(Graphics g) {
		if (Settings.SHOW_FISHING_OVERLAY) {
			g.setFont(Game.runescapeFont);
			if (this.g2d == null)
				this.g2d = (Graphics2D) g;
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					g.setColor(ActorNames.playerNameColor);
					Npc[] ns = Hooks.client.getCachedNpcs();
					if (ns != null) {
						for (Npc pl : ns) {
							if (pl != null) {
								String name = pl.getNpcComposition().getName();
								if (name != null) {
									if (name.contains("Fishing")) {
										String[] actions = pl.getNpcComposition().getActions();
										if (actions.length > 1) {
											if (Settings.SHOW_FISHING_CAGE_HARPOON)
												if (actions[0].compareTo("Cage") == 0) {
													for (String s : actions) {
														if (s != null)
															if (s.compareTo("Harpoon") == 0) {
																Polygon p = pl.asActor().getTileAreaOnScreen();
																if (p != null) {
																	g.setColor(ObjectManager.outlineColor);
																	((Graphics2D) g).draw(p);
																	g.setColor(ObjectManager.fillColor);
																	((Graphics2D) g).fill(p);
																	g.setColor(ActorNames.npcNameColor);
																}
															}
													}
												}
											if (Settings.SHOW_FISHING_NET_BAIT)
												if (actions[0].compareTo("Small Net") == 0) {
													for (String s : actions) {
														if (s != null)
															if (s.compareTo("Bait") == 0) {
																Polygon p = pl.asActor().getTileAreaOnScreen();
																if (p != null) {
																	g.setColor(ObjectManager.outlineColor);
																	((Graphics2D) g).draw(p);
																	g.setColor(ObjectManager.fillColor);
																	((Graphics2D) g).fill(p);
																	g.setColor(ActorNames.npcNameColor);
																}
															}
													}
												}
											if (Settings.SHOW_FISHING_NET_HARPOON)
												if (actions[0].compareTo("Big Net") == 0) {
													for (String s : actions) {
														if (s != null)
															if (s.compareTo("Harpoon") == 0) {
																Polygon p = pl.asActor().getTileAreaOnScreen();
																if (p != null) {
																	g.setColor(ObjectManager.outlineColor);
																	((Graphics2D) g).draw(p);
																	g.setColor(ObjectManager.fillColor);
																	((Graphics2D) g).fill(p);
																	g.setColor(ActorNames.npcNameColor);
																}
															}
													}
												}
											if (Settings.SHOW_FISHING_BARBARIAN)
												for (String s : actions)
													if (s != null)
														if (s.compareTo("Use-rod") == 0) {
															Polygon p = pl.asActor().getTileAreaOnScreen();
															if (p != null) {
																g.setColor(ObjectManager.outlineColor);
																((Graphics2D) g).draw(p);
																g.setColor(ObjectManager.fillColor);
																((Graphics2D) g).fill(p);
																g.setColor(ActorNames.npcNameColor);
															}
														}
										}
									}
								}
							}
						}
						for (Npc pl : ns) {
							if (pl != null) {
								String name = pl.getNpcComposition().getName();
								if (name != null) {
									if (name.contains("Fishing")) {
										String[] actions = pl.getNpcComposition().getActions();
										if (Settings.SHOW_FISHING_CAGE_HARPOON)
											if (actions[0].compareTo("Cage") == 0) {
												for (String ss : actions) {
													if (ss != null)
														if (ss.compareTo("Harpoon") == 0) {
															int i = 50;
															for (String s : actions) {
																if (s != null) {
																	Point p1 = Perspective.getCanvasTextLocation(
																			Hooks.client, (Graphics2D) g,
																			new LocalPoint(pl.asActor().getX(),
																					pl.asActor().getY()),
																			s, i);
																	if (p1 != null && name != null
																			&& name.compareTo("null") != 0) //$NON-NLS-1$
																		g.drawString(s, p1.getX(), p1.getY());
																	i -= 50;
																}
															}
														}
												}
											}
										if (Settings.SHOW_FISHING_NET_BAIT)
											if (actions[0].compareTo("Small Net") == 0) {
												for (String ss : actions) {
													if (ss != null)
														if (ss.compareTo("Bait") == 0) {
															int i = 50;
															for (String s : actions) {
																if (s != null) {
																	Point p1 = Perspective.getCanvasTextLocation(
																			Hooks.client, (Graphics2D) g,
																			new LocalPoint(pl.asActor().getX(),
																					pl.asActor().getY()),
																			s, i);
																	if (p1 != null && name != null
																			&& name.compareTo("null") != 0) //$NON-NLS-1$
																		g.drawString(s, p1.getX(), p1.getY());
																	i -= 50;
																}
															}
														}
												}
											}
										if (Settings.SHOW_FISHING_NET_HARPOON)
											if (actions[0].compareTo("Big Net") == 0) {
												for (String ss : actions) {
													if (ss != null)
														if (ss.compareTo("Harpoon") == 0) {
															int i = 50;
															for (String s : actions) {
																if (s != null) {
																	Point p1 = Perspective.getCanvasTextLocation(
																			Hooks.client, (Graphics2D) g,
																			new LocalPoint(pl.asActor().getX(),
																					pl.asActor().getY()),
																			s, i);
																	if (p1 != null && name != null
																			&& name.compareTo("null") != 0)
																		g.drawString(s, p1.getX(), p1.getY());
																	i -= 50;
																}
															}
														}
												}
											}
										if (Settings.SHOW_FISHING_BARBARIAN)
											for (String ss : actions) {
												if (ss != null)
													if (ss.compareTo("Use-rod") == 0) {
														int i = 50;
														for (String s : actions) {
															if (s != null) {
																Point p1 = Perspective.getCanvasTextLocation(
																		Hooks.client, (Graphics2D) g,
																		new LocalPoint(pl.asActor().getX(),
																				pl.asActor().getY()),
																		s, i);
																if (p1 != null && name != null
																		&& name.compareTo("null") != 0)
																	g.drawString("Leaping", p1.getX(), p1.getY());
																i -= 50;
															}
														}
													}
											}
									}
								}
							}
						}
					}
				}
		}
	}
}
