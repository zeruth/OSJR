package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class111 extends RSClass{
	
	public static final String sfx_index ="sfx_index";
	public static final String vorbis_index ="vorbis_index";

	public Class111() {
		super(Hooks.classNames.get("class111"));
	}
	
	public IndexDataBase getSFXIndex() {
		return new IndexDataBase(getField(sfx_index).getValue(reference));
	}
	
	public IndexDataBase getVorbisIndex() {
		return new IndexDataBase(getField(vorbis_index).getValue(reference));
	}

}