package reflection;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import game.RSAppletStub;
import game.Settings;

public class JarLoader extends ClassLoader {

	private RSAppletStub appleStub;
	private ClassLoader classLoader;
	private Hashtable<String, ClassNode> classnodes;

	private String gamepackUrl;

	public JarLoader() {
		this.appleStub = new RSAppletStub();
		this.classnodes = new Hashtable<>();
		this.gamepackUrl = this.appleStub.getLink() + this.appleStub.getParameter("initial_jar");
		loadJar();

		JarInjector injector = new JarInjector(this.classnodes);
		injector.run();
		this.classnodes = injector.getClassnodes();

		try {
			this.classLoader = URLClassLoader.newInstance(new URL[] { injector.getInjectedJar().toURI().toURL() });
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public RSAppletStub getAppletStub() {
		return this.appleStub;
	}

	public Hashtable<String, ClassNode> getClassnodes() {
		return this.classnodes;
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return this.classLoader.loadClass(name);
	}

	private void loadJar() {
		try {
			if (Settings.DOWNLOAD_GAMEPACK) {
				long start = System.currentTimeMillis();
				ReadableByteChannel rbc = Channels.newChannel(new URL(this.gamepackUrl).openStream());
				FileOutputStream fos = new FileOutputStream("gamepack.jar");
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

				System.out.println("Gamepack download took " + (System.currentTimeMillis() - start) + "ms");

			} else {
			}
			try (JarFile jar = new JarFile(new File("./resources/gamepack.jar"))) {
				Enumeration<JarEntry> en = jar.entries();
				while (en.hasMoreElements()) {
					JarEntry entry = en.nextElement();
					if (entry.getName().endsWith(".class")) {
						ClassReader cr = new ClassReader(jar.getInputStream(entry));
						ClassNode cn = new ClassNode();
						cr.accept(cn, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
						this.classnodes.put(cn.name, cn);
					}
				}
				jar.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}