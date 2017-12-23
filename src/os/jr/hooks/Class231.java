package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class231 extends GameClass{
	
	public static final String vorbisIndex = "vorbisIndex";

	public Class231() {
		super(Hooks.classNames.get("class231"));
	}
	
	public IndexData getVorbisIndex() {
		return new IndexData(fields.get(vorbisIndex).getValue(reference));
	}

}