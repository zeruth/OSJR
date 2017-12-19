package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class Bounds extends GameClass{
	
	public static String spritePixels = "spritePixels";

	public Bounds() {
		super(Hooks.classNames.get("Bounds"));
	}
	
	public byte[][] getSpritePixels() {
		return (byte[][]) Hooks.selector.bounds.fields.get(spritePixels).getValue(reference);
	}

}
