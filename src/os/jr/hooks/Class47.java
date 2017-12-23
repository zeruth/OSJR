package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class47 extends RSClass{
	
	public static final String mapedge = "mapedge";

	public Class47() {
		super(Hooks.classNames.get("class47"));
	}
	
	public SpritePixels getMapEdge() {
		return new SpritePixels(getField(mapedge).getValue(reference));
	}

}