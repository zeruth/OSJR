package paint;

import java.util.Hashtable;
import java.util.ListIterator;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class CanvasInjector {
	public static void setSuper(ClassNode node, String superClass) {
		String replaced = "";
		if (!node.superName.equals(""))
			replaced = node.superName;
		if (!replaced.equals("")) {
			for (Object o : node.methods) {
				final MethodNode mn = (MethodNode) o;
				final ListIterator<?> listIt = mn.instructions.iterator();
				while (listIt.hasNext()) {
					final AbstractInsnNode ain = (AbstractInsnNode) listIt.next();
					if (ain.getOpcode() == Opcodes.INVOKESPECIAL) {
						final MethodInsnNode call = (MethodInsnNode) ain;
						if (call.owner.equals(replaced))
							call.owner = superClass;
					}
				}
			}
		}
		node.superName = superClass;
	}

	private Hashtable<String, ClassNode> classnodes;

	public CanvasInjector(Hashtable<String, ClassNode> classnodes) {
		super();
		this.classnodes = classnodes;
	}

	public Hashtable<String, ClassNode> getClassnodes() {
		return classnodes;
	}

	public Hashtable<String, ClassNode> run() {
		for (ClassNode cn : classnodes.values()) {
			if (cn.superName.toLowerCase().contains("canvas")) {
				setSuper(cn, "paint/GameCanvas");
			}
		}
		return classnodes;
	}

}
