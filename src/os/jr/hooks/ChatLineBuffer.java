package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class ChatLineBuffer extends RSClass {

	public static final String lines = "lines";
	public static final String length = "length";

	public ChatLineBuffer() {
		super(Hooks.classNames.get("ChatLineBuffer"));
	}

	public int getLength() {
		return (int) getField(length).getValue(reference);
	}

	public MessageNode[] getLines() {
		Object[] os = (Object[]) getField(lines).getValue(reference);
		MessageNode[] lines = new MessageNode[os.length];
		int count = 0;
		for (Object o : os) {
			lines[count] = new MessageNode(o);
			count++;
		}
		return lines;
	}

}
