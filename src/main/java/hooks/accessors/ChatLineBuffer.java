package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class ChatLineBuffer extends RSClass {

	public ChatLineBuffer(Object reference) {
		this.reference = reference;
		if (Hooks.sequence != null) {
			this.fields = Hooks.sequence.fields;
			this.name = Hooks.sequence.name;
			this.obfuscatedName = Hooks.sequence.obfuscatedName;
		}
	}

}
