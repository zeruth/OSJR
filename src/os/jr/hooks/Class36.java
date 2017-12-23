package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class36 extends RSClass{
	
	public static final String soundSystem0 = "soundSystem0";
	public static final String indexCache10 = "indexCache10";
	public static final String selectedItemIndex = "selectedItemIndex";

	public Class36() {
		super(Hooks.classNames.get("class36"));
	}

	public AbstractSoundSystem getSoundSystem0() {
		return new AbstractSoundSystem(getField(soundSystem0).getValue(reference));
	}
	
	public IndexData getIndexCache10() {
		return new IndexData(getField(indexCache10).getValue(reference));
	}
	
	public int getSelectedItemIndex() {
		return (int) getField(selectedItemIndex).getValue(reference);
	}
}