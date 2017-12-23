package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class231 extends RSClass{
	
	public static final String vorbisIndex = "vorbisIndex";

	public Class231() {
		super(Hooks.classNames.get("class231"));
	}
	
	public IndexData getVorbisIndex() {
		return new IndexData(getField(vorbisIndex).getValue(reference));
	}

}