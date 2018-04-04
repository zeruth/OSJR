package paint;

import java.applet.Applet;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import discord.UpdateStatus;
import game.Game;
import game.Settings;
import paint.agility.AgilityOverlay;

public class MenuHandler implements ActionListener {
	
	public static Applet colorPick;

	private JMenuItem actorNames;

	private JMenuItem agilityOverlay;

	private JMenuItem debug;
	private JMenuItem decorativeObjects;
	private JMenu discordMenu;
	private JMenuItem fps;
	private JFrame frame;
	private JMenuItem gameObjects;
	private JMenuItem groundObjects;
	private JMenu colorPicker;
	private JMenuItem colorOutline;
	private JMenuItem colorFill;
	private JMenuItem colorNPCName;
	private JMenuItem colorPlayerName;
	private JMenuItem colorClanMateName;


	// Menus
	private JMenuBar menuBar;
	private JMenuItem pack;
	// Settings
	private JMenu settingsMenu;
	private JMenu skillOverlays;
	private JMenuItem updateStatus;

	public JFrame updateStatusWindow;

	private JMenuItem wallObjects;

	public MenuHandler(JFrame frame, Game game) {
		this.frame = frame;

		this.menuBar = new JMenuBar();

		// Settings
		this.settingsMenu = new JMenu("Settings");
		this.discordMenu = new JMenu("Discord");
		this.skillOverlays = new JMenu("Skill Overlays");
		this.colorPicker = new JMenu("Change Colors");

		this.fps = new JMenuItem("Draw Fps");
		this.actorNames = new JMenuItem("Draw Actor Names");
		this.groundObjects = new JMenuItem("Draw GroundObject ID's (Laggy)");
		this.gameObjects = new JMenuItem("Draw GameObject ID's (Laggy)");
		this.decorativeObjects = new JMenuItem("Draw DecorativeObject ID's (Laggy)");
		this.wallObjects = new JMenuItem("Draw WallObject ID's (Laggy)");
		this.colorOutline = new JMenuItem("Outline");
		this.colorFill = new JMenuItem("Fill");
		this.colorNPCName = new JMenuItem("NPC Names");
		this.colorPlayerName = new JMenuItem("Player Names");
		this.colorClanMateName = new JMenuItem("ClanMate Names");

		this.updateStatus = new JMenuItem("Update Status");

		this.agilityOverlay = new JMenuItem("Agility");

		this.fps.addActionListener(this);
		this.actorNames.addActionListener(this);
		this.groundObjects.addActionListener(this);
		this.gameObjects.addActionListener(this);
		this.decorativeObjects.addActionListener(this);
		this.wallObjects.addActionListener(this);
		this.colorPicker.addActionListener(this);
		this.colorOutline.addActionListener(this);
		this.colorFill.addActionListener(this);
		this.colorNPCName.addActionListener(this);
		this.colorPlayerName.addActionListener(this);
		this.colorClanMateName.addActionListener(this);
		
		this.colorPicker.add(this.colorOutline);
		this.colorPicker.add(this.colorFill);
		this.colorPicker.add(this.colorNPCName);
		this.colorPicker.add(this.colorPlayerName);
		this.colorPicker.add(this.colorClanMateName);

		this.updateStatus.addActionListener(this);

		this.agilityOverlay.addActionListener(this);

		this.settingsMenu.add(this.fps);
		this.settingsMenu.add(this.actorNames);
		this.settingsMenu.add(this.groundObjects);
		this.settingsMenu.add(this.gameObjects);
		this.settingsMenu.add(this.decorativeObjects);
		this.settingsMenu.add(this.wallObjects);
		this.settingsMenu.add(this.colorPicker);

		this.discordMenu.add(this.updateStatus);

		this.skillOverlays.add(this.agilityOverlay);

		this.menuBar.add(this.settingsMenu);
		this.menuBar.add(this.discordMenu);
		this.menuBar.add(this.skillOverlays);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.debug)) {
			Settings.SHOW_DEBUG = !Settings.SHOW_DEBUG;
		}
		if (e.getSource().equals(this.fps)) {
			Settings.SHOW_FPS = !Settings.SHOW_FPS;
		}
		if (e.getSource().equals(this.actorNames)) {
			Settings.SHOW_PLAYER_NAMES = !Settings.SHOW_PLAYER_NAMES;
		}
		if (e.getSource().equals(this.groundObjects)) {
			Settings.SHOW_GROUNDOBJECT_IDS = !Settings.SHOW_GROUNDOBJECT_IDS;
		}
		if (e.getSource().equals(this.gameObjects)) {
			Settings.SHOW_GAMEOBJECT_IDS = !Settings.SHOW_GAMEOBJECT_IDS;
		}
		if (e.getSource().equals(this.decorativeObjects)) {
			Settings.SHOW_DECORATIVEOBJECT_IDS = !Settings.SHOW_DECORATIVEOBJECT_IDS;
		}
		if (e.getSource().equals(this.wallObjects)) {
			Settings.SHOW_WALLOBJECT_IDS = !Settings.SHOW_WALLOBJECT_IDS;
		}
		if (e.getSource().equals(this.agilityOverlay)) {
			Settings.SHOW_AGILITY_OVERLAY = !Settings.SHOW_AGILITY_OVERLAY;
		}
		if (e.getSource().equals(this.updateStatus)) {
			if (this.updateStatusWindow == null)
				this.updateStatusWindow = new UpdateStatus();
			if (!this.updateStatusWindow.isVisible())
				this.updateStatusWindow.setVisible(true);
		}
		if (e.getSource().equals(this.colorOutline)) {
			colorPick = new ColorChooserApplet(AgilityOverlay.outlineColor);
			JFrame colors = new JFrame("ColorPicker");
			colors.setSize(800, 600);
			colors.setVisible(true);
			colors.getContentPane().add(colorPick);
			colorPick.init();
			colorPick.start();
		}
		if (e.getSource().equals(this.pack)) {
			this.frame.pack();
		}
	}

	private static BufferedImage getScaledImage(BufferedImage src, int h) {
		int finalh = h;
		double factor = 1.0d;

		factor = ((double) src.getWidth() / (double) src.getHeight());
		int finalw = (int) (finalh * factor);

		BufferedImage resizedImg = new BufferedImage(finalw, finalh, Transparency.TRANSLUCENT);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(src, 0, 0, finalw, finalh, null);
		g2.dispose();
		return resizedImg;
	}

	public JMenuBar makeJMenuBar() {
		return this.menuBar;
	}

}
