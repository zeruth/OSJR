package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class ContextMenuRow extends RSClass {
	
	public static final String highMemory = "highMemory";
	public static final String param0 = "param0";
	public static final String param1 = "param1";
	public static final String type = "type";
	public static final String identifier = "identifier";
	public static final String option = "option";

	public ContextMenuRow() {
		super(Hooks.classNames.get("ContextMenuRow"));
	}
	
	public boolean highMemory() {
		return (boolean) getField(highMemory).getValue(reference);
	}
	
	public int getParam0() {
		return (int) getField(param0).getValue(reference);
	}
	
	public int getParam1() {
		return (int) getField(param1).getValue(reference);
	}
	
	public int getType() {
		return (int) getField(type).getValue(reference);
	}
	
	public int getIdentifier() {
		return (int) getField(identifier).getValue(reference);
	}
	
	public String getOption() {
		return (String) getField(option).getValue(reference);
	}

}
