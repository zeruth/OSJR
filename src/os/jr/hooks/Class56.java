package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class56 extends RSClass{
	
	public static final String indexStore255 = "indexStore255";
	public static final String grandExchangeEvents = "grandExchangeEvents";
	public static final String fontPlain11 = "fontPlain11";

	public Class56() {
		super(Hooks.classNames.get("class56"));
	}
	
	public IndexFile getIndexStore255() {
		return new IndexFile(getField(indexStore255).getValue(reference));
	}
	
	public GrandExchangeEvents getGrandExchangeEvents() {
		return new GrandExchangeEvents(getField(grandExchangeEvents).getValue(reference));
	}

}