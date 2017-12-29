package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class FloorUnderlayDefinition extends RSClass {
	
	public static final String underlay_ref = "underlay_ref";
	public static final String underlays = "underlays";
	public static final String rgbColor = "rgbColor";
	public static final String hue = "hue";
	public static final String saturation = "saturation";
	public static final String lightness = "lightness";
	public static final String hueMultiplier = "hueMultiplier";
	

	public FloorUnderlayDefinition() {
		super(Hooks.classNames.get("FloorUnderlayDefinition"));
	}
	
	public IndexDataBase getUnderlay_ref() {
		return new IndexDataBase(getField(underlay_ref).getValue(reference));
	}
	
	public NodeCache getUnderlays() {
		return new NodeCache(getField(underlays).getValue(reference));
	}
	
	public int getRGBColor() {
		return (int) getField(rgbColor).getValue(reference);
	}
	
	public int getHue() {
		return (int) getField(hue).getValue(reference);
	}
	
	public int getSaturation() {
		return (int) getField(saturation).getValue(reference);
	}
	
	public int getLightness() {
		return (int) getField(lightness).getValue(reference);
	}

}
