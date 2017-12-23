package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class34 extends RSClass{
	
	public static final String seq_ref = "seq_ref";
	public static final String mapMarkers = "mapMarkers";

	public Class34() {
		super(Hooks.classNames.get("class34"));
	}
	
	public IndexDataBase getSeq_ref() {
		return new IndexDataBase(getField(seq_ref).getValue(reference));
	}
	
	public SpritePixels[] getMapMarkers() {
		Object[] os = (Object[]) getField(mapMarkers).getValue(reference);
		SpritePixels[] mapMarkers = new SpritePixels[os.length];
		int i = 0;
		for (Object o : os) {
			mapMarkers[i] = new SpritePixels(o);
			i++;
		}
		return mapMarkers;
	}

}