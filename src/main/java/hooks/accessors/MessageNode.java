package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class MessageNode extends RSClass {

	public MessageNode(Object reference) {
		this.reference = reference;
		if (Hooks.messageNode != null) {
			this.fields = Hooks.messageNode.fields;
			this.name = Hooks.messageNode.name;
			this.obfuscatedName = Hooks.messageNode.obfuscatedName;
		}
	}

	public int getID() {
		return (int) getValue(getField("id"));
	}

	public int getTick() {
		return (int) getValue(getField("tick"));
	}

	public int getType() {
		return (int) getValue(getField("type"));
	}

	public String getName() {
		String s = (String) getValue(getField("name"));
		s = s.replace("<img=2>", "(Ironman)");
		return s;
	}

	public String getSender() {
		String s = (String) getValue(getField("sender"));
		return s;
	}

	public String getMessage() {
		String s = (String) getValue(getField("value"));
		s = s.replace("<br>", "\n");
		s = s.replace("</col>", "");
		s = s.replace("<col=ff0000>", "");
		return s;
	}
}
