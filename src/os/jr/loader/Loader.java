package os.jr.loader;

import java.applet.Applet;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import os.jr.game.accessors.Client;

public class Loader extends ClassLoader{
	
	public static String gameUrl = "http://oldschool9.runescape.com/";
	private static File gamepackFile = new File(System.getProperty("user.home") + "/OSJR/gamepack.jar");
	public static URL gamepackURL;
	public static String mainClass;
	private Hashtable<String, ClassNode> classnodes;
	public static ClassLoader classLoader;


	public static Applet applet;
	public static final HashMap<String, String> Parameters = new HashMap<String, String>();
	
	public static Client client;

	public static Client getClient() {
		return client;
	}
	
	public Loader() throws IOException {
		classnodes = new Hashtable<String, ClassNode>();
		loadJar();
		
		try {
			classLoader = URLClassLoader.newInstance(new URL[] { gamepackFile.toURI().toURL() });
			applet = (Applet) classLoader.loadClass("client").newInstance();
		      applet.setSize(781, 543); //fixes game crash.
		      applet.setVisible(true);
		      applet.setPreferredSize(new Dimension(768, 528));
		      applet.setStub(new RSAppletStub());
		      applet.init();
		      applet.start();
		      
		      client = new Client(applet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadJar() throws IOException {
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
	}

}
