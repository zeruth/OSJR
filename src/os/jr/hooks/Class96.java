package os.jr.hooks;

import java.util.Map;

import os.jr.hooks.loader.GameClass;

public class Class96 extends GameClass{
	
	public static final String chatLineMap = "chatLineMap";
	public static final String messages = "messages";

	public Class96() {
		super(Hooks.classNames.get("class96"));
	}
	
	public Map<?, ?> getChatLineMap() {
		return (Map<?, ?>) fields.get(chatLineMap).getValue(reference);
	}
	
	public IterableHashTable getMessages() {
		return new IterableHashTable(fields.get(messages).getValue(reference));
	}

}