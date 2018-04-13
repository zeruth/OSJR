package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Node extends RSClass {

	public Node(Object reference) {
		this.reference = reference;
		if (Hooks.node != null) {
			this.fields = Hooks.node.fields;
			this.name = Hooks.node.name;
			this.obfuscatedName = Hooks.node.obfuscatedName;
		}
	}

	public boolean hasNext() {
		Object ref = getValue(getField("next"));
		if (ref != null)
			return true;
		return false;
	}

	public Node getNext() {
		Object ref = getValue(getField("next"));
		return new Node(ref);
	}

	public Node getPrevious() {
		Object ref = getValue(getField("previous"));
		return new Node(ref);
	}

}
