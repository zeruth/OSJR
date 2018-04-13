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

import cache.ObjectManager;
import discord.UpdateStatus;
import game.Game;
import game.Settings;
import hooks.helpers.SkillGlobe;
import paint.misc.ActorNames;

public class MenuHandler implements ActionListener {

	public static Applet colorPick;

	private JMenuItem actorNames;

	private JMenuItem agilityOverlay;
	private JMenuItem fishingNetBait = new JMenuItem("Small Net / Bait");
	private JMenuItem fishingCageHarpoon = new JMenuItem("Cage / Harpoon");
	private JMenuItem fishingNetHarpoon = new JMenuItem("Big Net / Harpoon");

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
	private JMenu xpGlobe;
	private JMenuItem globeClear = new JMenuItem("Clear");
	private JMenuItem globeAttack = new JMenuItem("AttacK");
	private JMenuItem globeDefence = new JMenuItem("Defence");
	private JMenuItem globeStrength = new JMenuItem("Strength");
	private JMenuItem globeHitpoints = new JMenuItem("Hitpoints");
	private JMenuItem globeRanged = new JMenuItem("Ranged");
	private JMenuItem globePrayer = new JMenuItem("Prayer");
	private JMenuItem globeMagic = new JMenuItem("Magic");
	private JMenuItem globeCooking = new JMenuItem("Cooking");
	private JMenuItem globeWoodcutting = new JMenuItem("Woodcutting");
	private JMenuItem globeFletching = new JMenuItem("Fletching");
	private JMenuItem globeFishing = new JMenuItem("Fishing");
	private JMenuItem globeFiremaking = new JMenuItem("Firemaking");
	private JMenuItem globeCrafting = new JMenuItem("Crafting");
	private JMenuItem globeSmithing = new JMenuItem("Smithing");
	private JMenuItem globeMining = new JMenuItem("Mining");
	private JMenuItem globeHerblore = new JMenuItem("Herblore");
	private JMenuItem globeAgility = new JMenuItem("Agility");
	private JMenuItem globeThieving = new JMenuItem("Thieving");
	private JMenuItem globeSlayer = new JMenuItem("Slayer");
	private JMenuItem globeFarming = new JMenuItem("Farming");
	private JMenuItem globeRunecrafting = new JMenuItem("Runecrafting");
	private JMenuItem globeHunter = new JMenuItem("Hunter");
	private JMenuItem globeConstruction = new JMenuItem("Construction");
	private JMenuItem fishingBarbarian = new JMenuItem("Barbarian");

	// Menus
	private JMenuBar menuBar;
	private JMenuItem pack;
	// Settings
	private JMenu settingsMenu;
	private JMenu skillOverlays;
	private JMenu fishingRoot = new JMenu("Fishing");
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
		this.xpGlobe = new JMenu("XP Globe");

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
		this.fishingRoot.add(this.fishingNetBait);
		this.fishingRoot.add(this.fishingCageHarpoon);
		this.fishingRoot.add(this.fishingNetHarpoon);
		this.fishingRoot.add(this.fishingBarbarian);

		this.colorPicker.add(this.colorOutline);
		this.colorPicker.add(this.colorFill);
		this.colorPicker.add(this.colorNPCName);
		this.colorPicker.add(this.colorPlayerName);
		this.colorPicker.add(this.colorClanMateName);

		this.updateStatus.addActionListener(this);

		this.agilityOverlay.addActionListener(this);
		this.fishingNetBait.addActionListener(this);
		this.fishingCageHarpoon.addActionListener(this);
		this.fishingNetHarpoon.addActionListener(this);
		this.colorPlayerName.addActionListener(this);
		this.colorClanMateName.addActionListener(this);

		this.settingsMenu.add(this.fps);
		this.settingsMenu.add(this.actorNames);
		this.settingsMenu.add(this.groundObjects);
		this.settingsMenu.add(this.gameObjects);
		this.settingsMenu.add(this.decorativeObjects);
		this.settingsMenu.add(this.wallObjects);
		this.settingsMenu.add(this.colorPicker);

		this.discordMenu.add(this.updateStatus);

		this.skillOverlays.add(this.agilityOverlay);
		this.skillOverlays.add(this.fishingRoot);

		this.xpGlobe.add(this.globeClear);
		this.xpGlobe.add(this.globeAgility);
		this.xpGlobe.add(this.globeAttack);
		this.xpGlobe.add(this.globeCooking);
		this.xpGlobe.add(this.globeConstruction);
		this.xpGlobe.add(this.globeCrafting);
		this.xpGlobe.add(this.globeDefence);
		this.xpGlobe.add(this.globeFarming);
		this.xpGlobe.add(this.globeFletching);
		this.xpGlobe.add(this.globeFiremaking);
		this.xpGlobe.add(this.globeFishing);
		this.xpGlobe.add(this.globeHerblore);
		this.xpGlobe.add(this.globeHitpoints);
		this.xpGlobe.add(this.globeHunter);
		this.xpGlobe.add(this.globeMagic);
		this.xpGlobe.add(this.globeMining);
		this.xpGlobe.add(this.globePrayer);
		this.xpGlobe.add(this.globeRanged);
		this.xpGlobe.add(this.globeRunecrafting);
		this.xpGlobe.add(this.globeSlayer);
		this.xpGlobe.add(this.globeSmithing);
		this.xpGlobe.add(this.globeStrength);
		this.xpGlobe.add(this.globeThieving);
		this.xpGlobe.add(this.globeWoodcutting);

		this.globeClear.addActionListener(this);
		this.globeAttack.addActionListener(this);
		this.globeDefence.addActionListener(this);
		this.globeStrength.addActionListener(this);
		this.globeHitpoints.addActionListener(this);
		this.globeRanged.addActionListener(this);
		this.globePrayer.addActionListener(this);
		this.globeMagic.addActionListener(this);
		this.globeCooking.addActionListener(this);
		this.globeWoodcutting.addActionListener(this);
		this.globeFletching.addActionListener(this);
		this.globeFishing.addActionListener(this);
		this.globeFiremaking.addActionListener(this);
		this.globeCrafting.addActionListener(this);
		this.globeSmithing.addActionListener(this);
		this.globeMining.addActionListener(this);
		this.globeHerblore.addActionListener(this);
		this.globeAgility.addActionListener(this);
		this.globeThieving.addActionListener(this);
		this.globeSlayer.addActionListener(this);
		this.globeFarming.addActionListener(this);
		this.globeRunecrafting.addActionListener(this);
		this.globeHunter.addActionListener(this);
		this.globeConstruction.addActionListener(this);
		this.fishingBarbarian.addActionListener(this);

		this.menuBar.add(this.settingsMenu);
		this.menuBar.add(this.discordMenu);
		this.menuBar.add(this.skillOverlays);
		this.menuBar.add(this.xpGlobe);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.debug)) {
			Settings.SHOW_DEBUG = !Settings.SHOW_DEBUG;
		} else if (e.getSource().equals(this.fps)) {
			Settings.SHOW_FPS = !Settings.SHOW_FPS;
		} else if (e.getSource().equals(this.actorNames)) {
			Settings.SHOW_PLAYER_NAMES = !Settings.SHOW_PLAYER_NAMES;
		} else if (e.getSource().equals(this.groundObjects)) {
			Settings.SHOW_GROUNDOBJECT_IDS = !Settings.SHOW_GROUNDOBJECT_IDS;
		} else if (e.getSource().equals(this.gameObjects)) {
			Settings.SHOW_GAMEOBJECT_IDS = !Settings.SHOW_GAMEOBJECT_IDS;
		} else if (e.getSource().equals(this.decorativeObjects)) {
			Settings.SHOW_DECORATIVEOBJECT_IDS = !Settings.SHOW_DECORATIVEOBJECT_IDS;
		} else if (e.getSource().equals(this.wallObjects)) {
			Settings.SHOW_WALLOBJECT_IDS = !Settings.SHOW_WALLOBJECT_IDS;
		} else if (e.getSource().equals(this.agilityOverlay)) {
			Settings.SHOW_AGILITY_OVERLAY = !Settings.SHOW_AGILITY_OVERLAY;
		} else if (e.getSource().equals(this.fishingNetBait)) {
			if (!Settings.SHOW_FISHING_OVERLAY)
				Settings.SHOW_FISHING_OVERLAY = true;
			Settings.SHOW_FISHING_NET_BAIT = !Settings.SHOW_FISHING_NET_BAIT;
		} else if (e.getSource().equals(this.fishingCageHarpoon)) {
			if (!Settings.SHOW_FISHING_OVERLAY)
				Settings.SHOW_FISHING_OVERLAY = true;
			Settings.SHOW_FISHING_CAGE_HARPOON = !Settings.SHOW_FISHING_CAGE_HARPOON;
		} else if (e.getSource().equals(this.fishingNetHarpoon)) {
			if (!Settings.SHOW_FISHING_OVERLAY)
				Settings.SHOW_FISHING_OVERLAY = true;
			Settings.SHOW_FISHING_NET_HARPOON = !Settings.SHOW_FISHING_NET_HARPOON;
		} else if (e.getSource().equals(this.fishingBarbarian)) {
			if (!Settings.SHOW_FISHING_OVERLAY)
				Settings.SHOW_FISHING_OVERLAY = true;
			Settings.SHOW_FISHING_BARBARIAN = !Settings.SHOW_FISHING_BARBARIAN;
		} else if (e.getSource().equals(this.updateStatus)) {
			if (this.updateStatusWindow == null)
				this.updateStatusWindow = new UpdateStatus();
			if (!this.updateStatusWindow.isVisible())
				this.updateStatusWindow.setVisible(true);
		} else if (e.getSource().equals(this.colorOutline)) {
			colorPick = new ColorChooserApplet(ObjectManager.outlineColor);
			JFrame colors = new JFrame("ColorPicker");
			colors.setSize(400, 200);
			colors.setVisible(true);
			colors.getContentPane().add(colorPick);
			colorPick.init();
			colorPick.start();
		} else if (e.getSource().equals(this.colorFill)) {
			colorPick = new ColorChooserApplet(ObjectManager.fillColor);
			JFrame colors = new JFrame("ColorPicker");
			colors.setSize(400, 200);
			colors.setVisible(true);
			colors.getContentPane().add(colorPick);
			colorPick.init();
			colorPick.start();
		} else if (e.getSource().equals(this.colorNPCName)) {
			colorPick = new ColorChooserApplet(ActorNames.npcNameColor);
			JFrame colors = new JFrame("ColorPicker");
			colors.setSize(400, 200);
			colors.setVisible(true);
			colors.getContentPane().add(colorPick);
			colorPick.init();
			colorPick.start();
		} else if (e.getSource().equals(this.colorPlayerName)) {
			colorPick = new ColorChooserApplet(ActorNames.playerNameColor);
			JFrame colors = new JFrame("ColorPicker");
			colors.setSize(400, 200);
			colors.setVisible(true);
			colors.getContentPane().add(colorPick);
			colorPick.init();
			colorPick.start();
		} else if (e.getSource().equals(this.colorClanMateName)) {
			colorPick = new ColorChooserApplet(ActorNames.clanMateNameColor);
			JFrame colors = new JFrame("ColorPicker");
			colors.setSize(400, 200);
			colors.setVisible(true);
			colors.getContentPane().add(colorPick);
			colorPick.init();
			colorPick.start();
		} else if (e.getSource().equals(this.pack)) {
			this.frame.pack();
		} else if (e.getSource().equals(this.globeClear)) {
			SkillGlobe.activeSkillGlobe = null;
		} else if (e.getSource().equals(this.globeAttack)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(0);
		} else if (e.getSource().equals(this.globeDefence)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(1);
		} else if (e.getSource().equals(this.globeStrength)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(2);
		} else if (e.getSource().equals(this.globeHitpoints)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(3);
		} else if (e.getSource().equals(this.globeRanged)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(4);
		} else if (e.getSource().equals(this.globePrayer)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(5);
		} else if (e.getSource().equals(this.globeMagic)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(6);
		} else if (e.getSource().equals(this.globeCooking)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(7);
		} else if (e.getSource().equals(this.globeWoodcutting)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(8);
		} else if (e.getSource().equals(this.globeFletching)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(9);
		} else if (e.getSource().equals(this.globeFishing)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(10);
		} else if (e.getSource().equals(this.globeFiremaking)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(11);
		} else if (e.getSource().equals(this.globeCrafting)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(12);
		} else if (e.getSource().equals(this.globeSmithing)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(13);
		} else if (e.getSource().equals(this.globeMining)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(14);
		} else if (e.getSource().equals(this.globeHerblore)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(15);
		} else if (e.getSource().equals(this.globeAgility)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(16);
		} else if (e.getSource().equals(this.globeThieving)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(17);
		} else if (e.getSource().equals(this.globeSlayer)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(18);
		} else if (e.getSource().equals(this.globeFarming)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(19);
		} else if (e.getSource().equals(this.globeRunecrafting)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(20);
		} else if (e.getSource().equals(this.globeHunter)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(21);
		} else if (e.getSource().equals(this.globeConstruction)) {
			SkillGlobe.activeSkillGlobe = new SkillGlobe(22);
		}
	}

	@SuppressWarnings("unused")
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
