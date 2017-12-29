package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Frame extends RSClass {
	
	public static final String skin = "skin";
	public static final String translator_x = "translator_x";
	public static final String translator_y = "translator_y";
	public static final String translator_z = "translator_z";
	public static final String showing = "showing";

	public Frame(Object reference) {
		super(Hooks.classNames.get("Frame"));
		this.reference = reference;
	}
	
	public FrameMap getSkin() {
		return new FrameMap(getField(skin).getValue(reference));
	}
	
	public int[] getTranslator_x() {
		return (int[]) getField(translator_x).getValue(reference);
	}
	
	public int[] getTranslator_y() {
		return (int[]) getField(translator_y).getValue(reference);
	}
	
	public int[] getTranslator_z() {
		return (int[]) getField(translator_z).getValue(reference);
	}

}
