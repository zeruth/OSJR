package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class61 extends RSClass{
	
	public static final String renderOverview = "renderOverview";
	public static final String tileHeights = "renderOverview";
	public static final String tileSettings = "tileSettings";

	public Class61() {
		super(Hooks.classNames.get("class61"));
	}
	
	public RenderOverview getRenderOverview() {
		return new RenderOverview(getField(renderOverview).getValue(reference));
	}
	
	public int[][][] getTileHeights() {
		return (int[][][]) getField(tileHeights).getValue(reference);
	}
	
	public byte[][][] getTileSettings() {
		return (byte[][][]) getField(tileSettings).getValue(reference);
	}

}