package reflection;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import paint.CanvasInjector;

public class JarInjector {
	private Hashtable<String, ClassNode> classnodes;
	private File injectedJar;

	public JarInjector(Hashtable<String, ClassNode> classnodes) {
		this.classnodes = classnodes;
	}

	public Hashtable<String, ClassNode> getClassnodes() {
		return this.classnodes;
	}

	public File getInjectedJar() {
		return this.injectedJar;
	}

	public void run() {
		this.classnodes = new CanvasInjector(this.classnodes).run();

		try {
			this.injectedJar = new File("./resources/gamepack_injected.jar");
			try (JarOutputStream jos = new JarOutputStream(new FileOutputStream(this.injectedJar))){
				for (ClassNode cn : this.classnodes.values()) {
					ClassWriter cw = new ClassWriter(1);
					cn.accept(cw);
					JarEntry entry = new JarEntry(cn.name + ".class");
					jos.putNextEntry(entry);
					jos.write(cw.toByteArray());
					jos.closeEntry();
				}
				jos.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
