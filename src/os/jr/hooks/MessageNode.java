package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class MessageNode extends GameClass{

	public MessageNode(Object reference) {
		super(Hooks.classNames.get("MessageNode"));
		this.reference = reference;
	}

}
