package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class36 extends GameClass{
	
	public static final String soundSystem0 = "soundSystem0";
	public static final String indexCache10 = "indexCache10";
	public static final String selectedItemIndex = "selectedItemIndex";

	public Class36() {
		super(Hooks.classNames.get("class36"));
	}

	public AbstractSoundSystem getSoundSystem0() {
		return new AbstractSoundSystem(fields.get(soundSystem0).getValue(reference));
	}
	
	public IndexData getIndexCache10() {
		return new IndexData(fields.get(indexCache10).getValue(reference));
	}
	
	public int getSelectedItemIndex() {
		return (int) fields.get(selectedItemIndex).getValue(reference);
	}
}