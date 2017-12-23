package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class BufferProvider extends RSClass {

	public static final String pixels = "pixels";
	public static final String width = "width";
	public static final String height = "height";

	public BufferProvider() {
		super(Hooks.classNames.get("BufferProvider"));
	}

	public int getHeight() {
		return (int) getField(height).getValue(reference);
	}

	public int[] getPixels() {
		return (int[]) getField(pixels).getValue(reference);
	}

	public int getWidth() {
		return (int) getField(width).getValue(reference);
	}

}
