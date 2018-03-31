package os.rs.game;

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

import os.rs.discord.DiscordManager;
import os.rs.hooks.Hooks;
import os.rs.hooks.accessors.Client;
import os.rs.paint.Console;
import os.rs.paint.agility.AgilityOverlay;
import os.rs.paint.listeners.ActorNames;
import os.rs.paint.listeners.DecorativeObjects;
import os.rs.paint.listeners.FpsPaintListener;
import os.rs.paint.listeners.GameObjects;
import os.rs.paint.listeners.GroundObjects;
import os.rs.paint.listeners.InputListeners;
import os.rs.paint.listeners.PaintListener;
import os.rs.paint.listeners.TextPaintListener;
import os.rs.paint.listeners.WallObjects;
import os.rs.reflection.JarLoader;

public class Game extends Canvas implements Runnable {

	public static Applet applet;
	public static JarLoader jarLoader;
	private static final long serialVersionUID = 1L;
	public boolean debug;
	private BufferedImage gameImage;
	private InputListeners inputListeners;
	public boolean loading = true;
	public BufferedImage paintImage;
	private List<PaintListener> paintListeners;
	private Thread paintThread;
	private List<TextPaintListener> textPaintListeners;
	public ThreadGroup threadGroup;

	public Game() {
		threadGroup = new ThreadGroup("RSGame");
		gameImage = new BufferedImage(765, 503, BufferedImage.TYPE_INT_RGB);
		paintImage = new BufferedImage(765, 503, BufferedImage.TYPE_INT_RGB);

		new Thread(new Runnable() {
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

					inputListeners = new InputListeners(true, applet);
					requestFocus();
					addMouseListener(inputListeners);
					addMouseMotionListener(inputListeners);
					addMouseWheelListener(inputListeners);
					addKeyListener(inputListeners);
					addFocusListener(inputListeners);

					paintListeners.add(new FpsPaintListener(Hooks.client));
					paintListeners.add(new ActorNames(Hooks.client));
					paintListeners.add(new GroundObjects(Hooks.client));
					paintListeners.add(new GameObjects(Hooks.client));
					paintListeners.add(new DecorativeObjects(Hooks.client));
					paintListeners.add(new WallObjects(Hooks.client));

					paintListeners.add(new AgilityOverlay(Hooks.client));
				} catch (Exception e) {
					e.printStackTrace();
				}

				loading = false;
				System.out.println("[OSRS] Init Complete.");

			}
		}).start();

		paintListeners = new ArrayList<PaintListener>();
		textPaintListeners = new ArrayList<TextPaintListener>();

		paintThread = new Thread(threadGroup, this, "paint");
		paintThread.start();

		this.setSize(765, 503);
	}

	public void focus() {
		requestFocus();
	}

	public Graphics gamePaint() {
		return gameImage.getGraphics();
	}

	public Applet getApplet() {
		return applet;
	}

	@Override
	public void paint(Graphics g) {
		try {
			if (!this.isVisible())
				return;

			if (OSRSLauncher.loaderWindow.getHeight() != gameImage.getHeight()
					|| OSRSLauncher.loaderWindow.getWidth() != gameImage.getWidth()) {
				gameImage = new BufferedImage(OSRSLauncher.loaderWindow.getWidth(),
						OSRSLauncher.loaderWindow.getHeight(), BufferedImage.TYPE_INT_RGB);
				paintImage = new BufferedImage(OSRSLauncher.loaderWindow.getWidth(),
						OSRSLauncher.loaderWindow.getHeight(), BufferedImage.TYPE_INT_RGB);
				if (applet != null)
					applet.setSize(OSRSLauncher.loaderWindow.getContentPane().getSize());
			}

			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			Rectangle r = g2d.getClipBounds();
			if (loading) {
				g2d.drawImage(gameImage, r.x, r.y, r.x + r.width, r.y + r.height, r.x, r.y, r.x + r.width,
						r.y + r.height, null);
				return;
			}

			if (gameImage != null) {
				paintImage.flush();

				Graphics paintGraphics = paintImage.getGraphics();
				paintGraphics.drawImage(gameImage, r.x, r.y, r.x + r.width, r.y + r.height, r.x, r.y, r.x + r.width,
						r.y + r.height, null);

				for (PaintListener pl : paintListeners) {
					pl.onRepaint(paintGraphics);
				}

				for (TextPaintListener tpl : textPaintListeners) {
					int y = 40;
					paintGraphics.setColor(Color.cyan);
					String[] lines = tpl.onTextRepaint();
					if (lines != null) {
						for (String line : lines) {
							if (line == null)
								continue;
							paintGraphics.drawString(line, 20, y);
							y += 15;
						}
					}
				}

				g2d.drawImage(paintImage, r.x, r.y, r.x + r.width, r.y + r.height, r.x, r.y, r.x + r.width,
						r.y + r.height, null);
				paintGraphics.dispose();
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
