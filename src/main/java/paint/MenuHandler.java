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

		menuBar = new JMenuBar();

		// Settings
		settingsMenu = new JMenu("Settings");
		discordMenu = new JMenu("Discord");
		skillOverlays = new JMenu("Skill Overlays");

		fps = new JMenuItem("Draw Fps");
		actorNames = new JMenuItem("Draw Actor Names");
		groundObjects = new JMenuItem("Draw GroundObject ID's (Laggy)");
		gameObjects = new JMenuItem("Draw GameObject ID's (Laggy)");
		decorativeObjects = new JMenuItem("Draw DecorativeObject ID's (Laggy)");
		wallObjects = new JMenuItem("Draw WallObject ID's (Laggy)");
		consoleItem = new JMenuItem("Console");

		updateStatus = new JMenuItem("Update Status");

		agilityOverlay = new JMenuItem("Agility");

		fps.addActionListener(this);
		actorNames.addActionListener(this);
		groundObjects.addActionListener(this);
		gameObjects.addActionListener(this);
		decorativeObjects.addActionListener(this);
		consoleItem.addActionListener(this);
		wallObjects.addActionListener(this);

		updateStatus.addActionListener(this);

		agilityOverlay.addActionListener(this);

		settingsMenu.add(fps);
		settingsMenu.add(consoleItem);
		settingsMenu.add(actorNames);
		settingsMenu.add(groundObjects);
		settingsMenu.add(gameObjects);
		settingsMenu.add(decorativeObjects);
		settingsMenu.add(wallObjects);

		discordMenu.add(updateStatus);

		skillOverlays.add(agilityOverlay);

		menuBar.add(settingsMenu);
		menuBar.add(discordMenu);
		menuBar.add(skillOverlays);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(debug)) {
			Settings.SHOW_DEBUG = !Settings.SHOW_DEBUG;
		}
		if (e.getSource().equals(fps)) {
			Settings.SHOW_FPS = !Settings.SHOW_FPS;
		}
		if (e.getSource().equals(actorNames)) {
			Settings.SHOW_PLAYER_NAMES = !Settings.SHOW_PLAYER_NAMES;
		}
		if (e.getSource().equals(groundObjects)) {
			Settings.SHOW_GROUNDOBJECT_IDS = !Settings.SHOW_GROUNDOBJECT_IDS;
		}
		if (e.getSource().equals(gameObjects)) {
			Settings.SHOW_GAMEOBJECT_IDS = !Settings.SHOW_GAMEOBJECT_IDS;
		}
		if (e.getSource().equals(decorativeObjects)) {
			Settings.SHOW_DECORATIVEOBJECT_IDS = !Settings.SHOW_DECORATIVEOBJECT_IDS;
		}
		if (e.getSource().equals(wallObjects)) {
			Settings.SHOW_WALLOBJECT_IDS = !Settings.SHOW_WALLOBJECT_IDS;
		}
		if (e.getSource().equals(agilityOverlay)) {
			Settings.SHOW_AGILITY_OVERLAY = !Settings.SHOW_AGILITY_OVERLAY;
		}
		if (e.getSource().equals(updateStatus)) {
			if (updateStatusWindow == null)
				updateStatusWindow = new UpdateStatus();
			if (!updateStatusWindow.isVisible())
				updateStatusWindow.setVisible(true);
		}
		if (e.getSource().equals(pack)) {
			frame.pack();
		}
		if (e.getSource().equals(consoleItem)) {
			for (Component c : frame.getContentPane().getComponents()) {
				if (c.equals(console)) {
					frame.getContentPane().remove(console);
					Console.isOpen = false;
					frame.pack();
					return;
				}
			}
			frame.getContentPane().add(console, BorderLayout.EAST);
			frame.pack();
		}
	}

	@SuppressWarnings("unused")
	private BufferedImage getScaledImage(BufferedImage src, int h) {
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
		return menuBar;
	}

}
