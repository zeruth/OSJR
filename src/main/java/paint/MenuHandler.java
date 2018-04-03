package paint;

import java.awt.BorderLayout;
import java.awt.Component;
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

public class MenuHandler implements ActionListener {

	private JMenuItem actorNames;

	private JMenuItem agilityOverlay;
	private Console console;

	private JMenuItem consoleItem;

	private JMenuItem debug;
	private JMenuItem decorativeObjects;
	private JMenu discordMenu;
	private JMenuItem fps;
	private JFrame frame;
	private JMenuItem gameObjects;
	private JMenuItem groundObjects;
	// Menus
	private JMenuBar menuBar;
	private JMenuItem pack;
	// Settings
	private JMenu settingsMenu;
	private JMenu skillOverlays;
	private JMenuItem updateStatus;

	public JFrame updateStatusWindow;

	private JMenuItem wallObjects;

	public MenuHandler(JFrame frame, Game game, Console console) {
		this.frame = frame;
		this.console = console;

		this.menuBar = new JMenuBar();

		// Settings
		this.settingsMenu = new JMenu("Settings");
		this.discordMenu = new JMenu("Discord");
		this.skillOverlays = new JMenu("Skill Overlays");

		this.fps = new JMenuItem("Draw Fps");
		this.actorNames = new JMenuItem("Draw Actor Names");
		this.groundObjects = new JMenuItem("Draw GroundObject ID's (Laggy)");
		this.gameObjects = new JMenuItem("Draw GameObject ID's (Laggy)");
		this.decorativeObjects = new JMenuItem("Draw DecorativeObject ID's (Laggy)");
		this.wallObjects = new JMenuItem("Draw WallObject ID's (Laggy)");
		this.consoleItem = new JMenuItem("Console");

		this.updateStatus = new JMenuItem("Update Status");

		this.agilityOverlay = new JMenuItem("Agility");

		this.fps.addActionListener(this);
		this.actorNames.addActionListener(this);
		this.groundObjects.addActionListener(this);
		this.gameObjects.addActionListener(this);
		this.decorativeObjects.addActionListener(this);
		this.consoleItem.addActionListener(this);
		this.wallObjects.addActionListener(this);

		this.updateStatus.addActionListener(this);

		this.agilityOverlay.addActionListener(this);

		this.settingsMenu.add(this.fps);
		this.settingsMenu.add(this.consoleItem);
		this.settingsMenu.add(this.actorNames);
		this.settingsMenu.add(this.groundObjects);
		this.settingsMenu.add(this.gameObjects);
		this.settingsMenu.add(this.decorativeObjects);
		this.settingsMenu.add(this.wallObjects);

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
		if (e.getSource().equals(this.pack)) {
			this.frame.pack();
		}
		if (e.getSource().equals(this.consoleItem)) {
			for (Component c : this.frame.getContentPane().getComponents()) {
				if (c.equals(this.console)) {
					this.frame.getContentPane().remove(this.console);
					Console.isOpen = false;
					this.frame.pack();
					return;
				}
			}
			this.frame.getContentPane().add(this.console, BorderLayout.EAST);
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
