package game;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import discord.DiscordManager;
import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.Region;
import hooks.helpers.ObjectManager;
import paint.Console;
import paint.agility.AgilityOverlay;
import paint.listeners.ActorNames;
import paint.listeners.DecorativeObjects;
import paint.listeners.FpsPaintListener;
import paint.listeners.GameObjects;
import paint.listeners.GroundObjects;
import paint.listeners.InputListeners;
import paint.listeners.PaintListener;
import paint.listeners.TextPaintListener;
import paint.listeners.WallObjects;
import reflection.JarLoader;

public class Game extends Canvas implements Runnable {

	public static Applet applet;
	public static JarLoader jarLoader;
	private static final long serialVersionUID = 1L;
	public static boolean debug;
	private BufferedImage gameImage;
	InputListeners inputListeners;
	public boolean loading = true;
	public BufferedImage paintImage;
	List<PaintListener> paintListeners;
	private Thread paintThread;
	private List<TextPaintListener> textPaintListeners;
	public Region oldRegion = new Region(null);
	public static ThreadGroup threadGroup;
	public static boolean vanilla = false;
	public ObjectManager objectManager = new ObjectManager();
	
	Graphics2D g2d;
	Graphics paintGraphics;

	public Game(String[] args) {
		for (String s : args) {
			if (s.compareTo("vanilla") == 0) {
				vanilla = true;
			} else if (s.compareTo("debug")==0) {
				debug = true;
			}
		}
		if (vanilla) {
			jarLoader = new JarLoader();

			Class<?> c;
			try {
				c = jarLoader.loadClass("client");
				applet = (Applet) c.newInstance();
				applet.setStub(jarLoader.getAppletStub());
				JFrame vanillaFrame = new JFrame("Vanilla OSRS");
				applet.setSize(800, 600);
				vanillaFrame.setSize(800, 600);
				applet.init();
				applet.start();
				vanillaFrame.add(applet);
				vanillaFrame.setVisible(true);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			threadGroup = new ThreadGroup("RSGame");
			this.gameImage = new BufferedImage(765, 503, BufferedImage.TYPE_INT_RGB);
			this.paintImage = new BufferedImage(765, 503, BufferedImage.TYPE_INT_RGB);

			new Thread(new Runnable() {
				@SuppressWarnings("unused")
				@Override
				public void run() {
					try {
						jarLoader = new JarLoader();

						Class<?> c = jarLoader.loadClass("client");
						applet = (Applet) c.newInstance();
						applet.setStub(jarLoader.getAppletStub());
						applet.init();
						applet.setSize(OSRSLauncher.loaderWindow.getContentPane().getSize());
						applet.start();

						// Sleeping to let the game load
						Thread.sleep(1000);
						Hooks.client = new Client(applet);
						new Hooks();
						while (!Client.isLoaded()) {
							Thread.sleep(10);
						}

						DiscordManager.run();

						Game.this.inputListeners = new InputListeners(true, applet);
						requestFocus();
						addMouseListener(Game.this.inputListeners);
						addMouseMotionListener(Game.this.inputListeners);
						addMouseWheelListener(Game.this.inputListeners);
						addKeyListener(Game.this.inputListeners);
						addFocusListener(Game.this.inputListeners);

						Game.this.paintListeners.add(new FpsPaintListener(Hooks.client));
						Game.this.paintListeners.add(new ActorNames(Hooks.client));
						Game.this.paintListeners.add(new GroundObjects(Hooks.client));
						Game.this.paintListeners.add(new GameObjects(Hooks.client));
						Game.this.paintListeners.add(new DecorativeObjects(Hooks.client));
						Game.this.paintListeners.add(new WallObjects(Hooks.client));

						Game.this.paintListeners.add(new AgilityOverlay(Hooks.client));
						Game.this.objectManager.t.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					Game.this.loading = false;
					System.out.println("[OSRS] Init Complete.");

				}
			}).start();

			this.paintListeners = new ArrayList<>();
			this.textPaintListeners = new ArrayList<>();

			this.paintThread = new Thread(threadGroup, this, "paint");
			this.paintThread.start();

			this.setSize(765, 503);
		}

	}

	public void focus() {
		requestFocus();
	}

	public Graphics gamePaint() {
		return this.gameImage.getGraphics();
	}

	public static Applet getApplet() {
		return applet;
	}

	@Override
	public void paint(Graphics g) {
		try {
			if (!this.isVisible())
				return;

			if (OSRSLauncher.loaderWindow.getHeight() != this.gameImage.getHeight()
					|| OSRSLauncher.loaderWindow.getWidth() != this.gameImage.getWidth()) {
				this.gameImage = new BufferedImage(OSRSLauncher.loaderWindow.getWidth(),
						OSRSLauncher.loaderWindow.getHeight(), BufferedImage.TYPE_INT_RGB);
				this.paintImage = new BufferedImage(OSRSLauncher.loaderWindow.getWidth(),
						OSRSLauncher.loaderWindow.getHeight(), BufferedImage.TYPE_INT_RGB);
				if (applet != null)
					applet.setSize(OSRSLauncher.loaderWindow.getContentPane().getSize());
			}

			this.g2d = (Graphics2D) g;
			this.g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			this.g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			Rectangle r = this.g2d.getClipBounds();
			if (this.loading) {
				this.g2d.drawImage(this.gameImage, r.x, r.y, r.x + r.width, r.y + r.height, r.x, r.y, r.x + r.width,
						r.y + r.height, null);
				return;
			}

			if (this.gameImage != null) {
				this.paintImage.flush();

				this.paintGraphics = this.paintImage.getGraphics();
				this.paintGraphics.drawImage(this.gameImage, r.x, r.y, r.x + r.width, r.y + r.height, r.x, r.y, r.x + r.width,
						r.y + r.height, null);

				for (PaintListener pl : this.paintListeners) {
					pl.onRepaint(this.paintGraphics);
				}

				for (TextPaintListener tpl : this.textPaintListeners) {
					int y = 40;
					this.paintGraphics.setColor(Color.cyan);
					String[] lines = tpl.onTextRepaint();
					if (lines != null) {
						for (String line : lines) {
							if (line == null)
								continue;
							this.paintGraphics.drawString(line, 20, y);
							y += 15;
						}
					}
				}

				this.g2d.drawImage(this.paintImage, r.x, r.y, r.x + r.width, r.y + r.height, r.x, r.y, r.x + r.width,
						r.y + r.height, null);
				this.paintGraphics.dispose();
			}
		} catch (RasterFormatException ignored) {
		}
	}

	@Override
	public void paintAll(Graphics g) {
		paint(g);
	}

	@Override
	public void repaint(int x, int y, int width, int height) {
		super.repaint(0, 0, OSRSLauncher.loaderWindow.getWidth(), OSRSLauncher.loaderWindow.getHeight());
	}

	@Override
	public void repaint(long tm, int x, int y, int width, int height) {
		super.repaint(tm, 0, 0, OSRSLauncher.loaderWindow.getWidth(), getHeight());
	}

	@Override
	public void run() {
		while (true)
			try {
				if (this.isShowing()) {
					repaint();
					Thread.sleep(1000 / 50);
					if (!hasFocus() && !Console.isOpen())
						requestFocus();
				} else {
					Thread.sleep(300);
				}
			} catch (InterruptedException ignored) {
			}
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

}
