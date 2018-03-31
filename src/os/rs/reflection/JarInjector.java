package os.rs.reflection;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import os.rs.paint.CanvasInjector;

public class JarInjector {
	private Hashtable<String, ClassNode> classnodes;
	private File injectedJar;

	public JarInjector(Hashtable<String, ClassNode> classnodes) {
		this.classnodes = classnodes;
	}

	public Hashtable<String, ClassNode> getClassnodes() {
		return classnodes;
	}

	public File getInjectedJar() {
		return injectedJar;
	}

	public void run() {
		classnodes = new CanvasInjector(classnodes).run();

		try {
			injectedJar = new File("gamepack_injected.jar");
			JarOutputStream jos = new JarOutputStream(new FileOutputStream(injectedJar));

			for (ClassNode cn : classnodes.values()) {
				ClassWriter cw = new ClassWriter(1);
				cn.accept(cw);
				JarEntry entry = new JarEntry(cn.name + ".class");
				jos.putNextEntry(entry);
				jos.write(cw.toByteArray());
				jos.closeEntry();
			}
			jos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
