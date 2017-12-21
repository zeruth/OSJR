/**
 * Credits to Reich for the one page client source
 * I (Null) have of course heavily modified this source but none the less, thanks.
 * https://goo.gl/49W1Hg (Rune-Server Link)
 */

package os.jr.game;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.DataInputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import os.jr.hooks.loader.HooksLoader;
import os.jr.hooks.updater.HookUpdater;
import os.jr.ui.Updater;
import os.jr.utils.Settings;
import os.jr.utils.SettingsIo;
import os.jr.utils.Utils;

/**
 * A program that loads a jar file into a jframe
 * 
 * @author Cody Reichenbach
 * @author Null
 *
 */
public class RSGame implements AppletStub {

	public static Object rootReference;
	public static boolean outdated = false;

	private static File gamepackFile = new File(System.getProperty("user.home") + "/OSJR/gamepack.jar");

	public static URL LIVE_JAR_URL;

	public static Applet applet = new Applet();
	public static Settings settings;

	public static URLClassLoader classLoader;

	public static java.awt.SystemTray systemTray;
	public static final String VERSION = "1.0.0";
	public static final int HOOK_REVISION = 160;

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

	private final String MAIN_CLASS = "client";

	private final boolean VERBOSE = false;
	private URL CODE_BASE;
	private URL DOCUMENT_BASE;

	private final int FAVORITE_WORLD = 9;

	private String JAR_URL = "http://oldschool" + FAVORITE_WORLD + ".runescape.com/";

	public String gamepackUrl;

	private final Pattern REGEX_CODE = Pattern.compile("code=(.*) ");

	private final Pattern REGEX_ARCHIVE = Pattern.compile("archive=(.*) ");
	private final Pattern REGEX_PARAMETER = Pattern.compile("<param name=\"([^\\s]+)\"\\s+value=\"([^>]*)\">");

	private HashMap<String, String> PARAMETERS = new HashMap<>();

	public RSGame() {
		initSettings();
		getAppletStubData();
		Updater.checkUpdate();
	}

	private void addApplet() {
		applet.setStub(this);
		applet.setSize(766, 503);
		applet.init();
		applet.start();
	}

	@Override
	public void appletResize(int x, int y) {
		if (applet != null) {
			applet.setSize(x, y);
		}
	}

	@Override
	public AppletContext getAppletContext() {
		return applet != null ? applet.getAppletContext() : null;
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

	public void initSettings() {
		if (!SettingsIo.dir.exists()) {
			SettingsIo.dir.mkdir();
		}
		if (!SettingsIo.file.exists()) {
			SettingsIo.createBlankDb();
		}

		settings = SettingsIo.loadSettings();
	}

	@Override
	public boolean isActive() {
		return true;
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
					RSGame.rootReference = applet;
					addApplet();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				} finally {

				}
				HooksLoader.loadHooksJson();
				HookUpdater.init();
				Utils.sendDebugPrintln("OS-JR " + VERSION + " Loaded.");
				Utils.sendDebugPrintln("Hook Revision " + HOOK_REVISION);
			}
		}
	}

}