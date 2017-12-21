package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class111 extends GameClass{
	
	public static final String sfx_index ="sfx_index";
	public static final String vorbis_index ="vorbis_index";

	public Class111() {
		super(Hooks.classNames.get("class111"));
	}
	
	public IndexDataBase getSFXIndex() {
		return new IndexDataBase(fields.get(sfx_index).getValue(reference));
	}
	
	public IndexDataBase getVorbisIndex() {
		return new IndexDataBase(fields.get(vorbis_index).getValue(reference));
	}

}