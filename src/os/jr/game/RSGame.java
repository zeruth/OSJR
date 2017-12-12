/**
 * Credits to Reich
 * https://goo.gl/49W1Hg (Rune-Server Link)
 */

package os.jr.game;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import os.jr.boot.Boot;
import os.jr.boot.Updater;
import os.jr.hooks.Client;
import os.jr.hooks.Hooks;
import os.jr.hooks.updater.HookUpdater;
import os.jr.ui.Notes;
import os.jr.ui.StatMonitor;
import os.jr.utils.Settings;
import os.jr.utils.SettingsIo;
import os.jr.utils.Utils;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A program that loads a jar file into a jframe
 * 
 * @author Cody Reichenbach
 *
 */
public class RSGame extends JFrame implements AppletStub {

	private final String MAIN_CLASS = "client";

	private final boolean VERBOSE = true;

	private URL CODE_BASE;
	private URL DOCUMENT_BASE;

	private final int FAVORITE_WORLD = 9;

	private static File gamepackFile = new File(System.getProperty("user.home") + "/OSJR/gamepack.jar");
	private String JAR_URL = "http://oldschool" + FAVORITE_WORLD + ".runescape.com/";
	public String gamepackUrl;

	public static URL LIVE_JAR_URL;

	static Applet applet;

	private final Pattern REGEX_CODE = Pattern.compile("code=(.*) ");
	private final Pattern REGEX_ARCHIVE = Pattern.compile("archive=(.*) ");
	private final Pattern REGEX_PARAMETER = Pattern.compile("<param name=\"([^\\s]+)\"\\s+value=\"([^>]*)\">");

	private HashMap<String, String> PARAMETERS = new HashMap<>();
	
	private Hashtable<String, ClassNode> classnodes = new Hashtable<String, ClassNode>();
	
	public static URLClassLoader classLoader;


	public RSGame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("OS-JR");
		menuBar.add(mnFile);
		
		JMenuItem mntmHideMenu = new JMenuItem("Hide Menu");
		mntmHideMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuBar.setVisible(false);
			}
		});
		mnFile.add(mntmHideMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
		JMenuItem mntmStatMonitor = new JMenuItem("Stat Monitor");
		mntmStatMonitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StatMonitor.frame.setVisible(true);
			}
		});
		mnTools.add(mntmStatMonitor);
		
		JMenuItem mntmNotes = new JMenuItem("Notes");
		mntmNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notes.frame.setVisible(true);
			}
		});

		mnTools.add(mntmNotes);
		getContentPane().setLayout(null);
		Client.settings = SettingsIo.loadSettings();
		if (Client.settings == null) {
			Client.settings = new Settings();
			SettingsIo.saveSettings(Client.settings);
		}
		classnodes = new Hashtable<String, ClassNode>();
		getAppletStubData();
		Updater.main();
		loadJar();
	}

	public void run() {
		classLoader = null;
		try {
			classLoader = new URLClassLoader(new URL[] { gamepackFile.toURI().toURL() });
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			if (classLoader == null)
				return;
			Class<?> clientClass = null;
			try {
				clientClass = classLoader.loadClass(MAIN_CLASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (clientClass == null)
					return;
				try {
					applet = (Applet) clientClass.newInstance();
					addApplet();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				} finally {
					setSize(785, 525);
					setVisible(true);
				}
				Hooks.init();
				HookUpdater.init();
				this.setSize(782,566);
				System.out.println("\nOS-JR "+ Boot.VERSION + " Loaded.");
				System.out.println("Hook Revision "+Boot.HOOK_REVISION);
			}
		}
	}

	private void getAppletStubData() {
		String pageSource = getPage(JAR_URL);
		try {
			Matcher archiveMatcher = REGEX_ARCHIVE.matcher(pageSource);
			Matcher codeMatcher = REGEX_CODE.matcher(pageSource);
			if (archiveMatcher.find() && codeMatcher.find()) {

				String jarLink = JAR_URL + archiveMatcher.group(1);
				LIVE_JAR_URL = new URL(jarLink);
				if (VERBOSE)
					System.out.println("Jar location: " + jarLink);

				String codeName = codeMatcher.group(1).replaceAll(".class", "");
				if (VERBOSE)
					System.out.println("Code name: " + codeName);

				CODE_BASE = new URL(jarLink);
				DOCUMENT_BASE = LIVE_JAR_URL;

				if (VERBOSE)
					System.out.println("\nLoading parameters...");
				Matcher paramMatcher = REGEX_PARAMETER.matcher(pageSource);
				while (paramMatcher.find()) {
					String key = paramMatcher.group(1);
					String value = paramMatcher.group(2);
					if (VERBOSE)
						System.out.printf("%-20s %s", key, value + "\n");
					PARAMETERS.put(key, value);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void addApplet() {
		applet.setStub(this);
		getContentPane().add(applet, null);
		//setco
		applet.setSize(766, 503);
		applet.init();
		applet.start();
	}

	public static String getPage(String link) {
		try {
			URL url = new URL(link);
			URLConnection conn = url.openConnection();
			conn.addRequestProperty("Protocol", "HTTP/1.1");
			conn.addRequestProperty("Connection", "keep-alive");
			conn.addRequestProperty("Keep-Alive", "200");
			conn.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; rv:9.0.1) Gecko/20100101 Firefox/9.0.1");
			byte[] buffer = new byte[conn.getContentLength()];
			try (DataInputStream stream = new DataInputStream(conn.getInputStream())) {
				stream.readFully(buffer);
			}
			return new String(buffer);
		} catch (Exception ex) {
			System.out.println("Error while trying to get a page: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public void appletResize(int x, int y) {
		if (applet != null) {
			applet.setSize(x, y);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (applet != null) {
			applet.setSize(getContentPane().getWidth(), getContentPane().getHeight());
		}
	}

	@Override
	public AppletContext getAppletContext() {
		return applet != null ? applet.getAppletContext() : null;
	}

	@Override
	public URL getCodeBase() {
		return CODE_BASE;
	}

	@Override
	public URL getDocumentBase() {
		return DOCUMENT_BASE;
	}

	@Override
	public String getParameter(String key) {
		return PARAMETERS.get(key);
	}

	@Override
	public boolean isActive() {
		return true;
	}
	
	public void loadJar() {
		try {
			@SuppressWarnings("resource")
			JarFile jar = new JarFile(gamepackFile);
			Enumeration<JarEntry> en = jar.entries();
			while (en.hasMoreElements()) {
				JarEntry entry = en.nextElement();
				if (entry.getName().endsWith(".class")) {
					ClassReader cr = new ClassReader(jar.getInputStream(entry));
					ClassNode cn = new ClassNode();
					cr.accept(cn, true);
					classnodes.put(cn.name, cn);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void changeName(String name) {
		
		if (name == null) {
			this.setTitle("OS-JR" + Utils.getUTCTime());
		} else {
			this.setTitle("OS-JR [" + name + "]" + Utils.getUTCTime());
		}

	}
}