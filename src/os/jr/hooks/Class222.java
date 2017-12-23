package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class222 extends RSClass{
	
	public static final String varpsMasks = "varpsMasks";
	public static final String settings = "settings";
	public static final String widgetSettings = "widgetSettings";

	public Class222() {
		super(Hooks.classNames.get("class222"));
	}
	
	public int[] getVarpsMasks() {
		return (int[]) getField(varpsMasks).getValue(reference);
	}
	
	public int[] getSettings() {
		return (int[]) getField(settings).getValue(reference);
	}
	
	public int[] getWidgetSettings() {
		return (int[]) getField(widgetSettings).getValue(reference);
	}
	
	

}