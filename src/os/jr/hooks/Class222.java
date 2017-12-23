package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class222 extends GameClass{
	
	public static final String varpsMasks = "varpsMasks";
	public static final String settings = "settings";
	public static final String widgetSettings = "widgetSettings";

	public Class222() {
		super(Hooks.classNames.get("class222"));
	}
	
	public int[] getVarpsMasks() {
		return (int[]) fields.get(varpsMasks).getValue(reference);
	}
	
	public int[] getSettings() {
		return (int[]) fields.get(settings).getValue(reference);
	}
	
	public int[] getWidgetSettings() {
		return (int[]) fields.get(widgetSettings).getValue(reference);
	}
	
	

}