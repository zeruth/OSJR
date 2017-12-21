package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Bounds extends GameClass {

	public static String spritePixels = "spritePixels";

	public Bounds() {
		super(Hooks.classNames.get("Bounds"));
	}

	public byte[][] getSpritePixels() {
		return (byte[][]) fields.get(spritePixels).getValue(reference);
	}

}
