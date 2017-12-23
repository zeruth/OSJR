package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class61 extends GameClass{
	
	public static final String renderOverview = "renderOverview";
	public static final String tileHeights = "renderOverview";
	public static final String tileSettings = "tileSettings";

	public Class61() {
		super(Hooks.classNames.get("class61"));
	}
	
	public RenderOverview getRenderOverview() {
		return new RenderOverview(fields.get(renderOverview).getValue(reference));
	}
	
	public int[][][] getTileHeights() {
		return (int[][][]) fields.get(tileHeights).getValue(reference);
	}
	
	public byte[][][] getTileSettings() {
		return (byte[][][]) fields.get(tileSettings).getValue(reference);
	}

}