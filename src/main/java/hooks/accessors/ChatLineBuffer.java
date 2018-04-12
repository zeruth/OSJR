package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class ChatLineBuffer extends RSClass {

	public ChatLineBuffer(Object reference) {
		this.reference = reference;
		if (Hooks.chatLineBuffer != null) {
			this.fields = Hooks.chatLineBuffer.fields;
			this.name = Hooks.chatLineBuffer.name;
			this.obfuscatedName = Hooks.chatLineBuffer.obfuscatedName;
		}
	}

	public MessageNode[] getLines() {
		Object[] os = (Object[]) getValue(getField("lines"));
		if (os != null) {
			MessageNode[] mns = new MessageNode[os.length];
			int i = 0;
			for (Object o : os) {
				mns[i] = new MessageNode(o);
				i++;
			}
			return mns;
		}
		return null;
	}

	public int length() {
		return -1;
	}

}
