package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Bounds extends RSClass {

	public static String spritePixels = "spritePixels";

	public Bounds() {
		super(Hooks.classNames.get("Bounds"));
	}

	public byte[][] getSpritePixels() {
		return (byte[][]) getField(spritePixels).getValue(reference);
	}

}
