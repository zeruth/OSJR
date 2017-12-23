package os.jr.hooks;

import java.util.Map;

import os.jr.hooks.loader.RSClass;

public class Class96 extends RSClass{
	
	public static final String chatLineMap = "chatLineMap";
	public static final String messages = "messages";

	public Class96() {
		super(Hooks.classNames.get("class96"));
	}
	
	public Map<?, ?> getChatLineMap() {
		return (Map<?, ?>) getField(chatLineMap).getValue(reference);
	}
	
	public IterableHashTable getMessages() {
		return new IterableHashTable(getField(messages).getValue(reference));
	}

}