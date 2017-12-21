package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class BufferProvider extends GameClass {

	public static final String pixels = "pixels";
	public static final String width = "width";
	public static final String height = "height";

	public BufferProvider() {
		super(Hooks.classNames.get("BufferProvider"));
	}

	public int getHeight() {
		return (int) fields.get(height).getValue(reference);
	}

	public int[] getPixels() {
		return (int[]) fields.get(pixels).getValue(reference);
	}

	public int getWidth() {
		return (int) fields.get(width).getValue(reference);
	}

}
