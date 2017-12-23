package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class47 extends GameClass{
	
	public static final String mapedge = "mapedge";

	public Class47() {
		super(Hooks.classNames.get("class47"));
	}
	
	public SpritePixels getMapEdge() {
		return new SpritePixels(fields.get(mapedge).getValue(reference));
	}

}