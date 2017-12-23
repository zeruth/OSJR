package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class MessageNode extends RSClass {

	public MessageNode(Object reference) {
		super(Hooks.classNames.get("MessageNode"));
		this.reference = reference;
	}

}
