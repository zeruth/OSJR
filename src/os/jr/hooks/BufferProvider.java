package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class BufferProvider extends GameClass{
	
	public static final String pixels = "pixels";
	public static final String width = "width";
	public static final String height = "height";

	public BufferProvider() {
		super(Hooks.classNames.get("BufferProvider"));
	}
	
	public int[] getPixels() {
		return (int[]) Hooks.selector.bufferProvider.fields.get(pixels).getValue(reference);
	}
	
	public int getWidth() {
		return (int) Hooks.selector.bufferProvider.fields.get(width).getValue(reference);
	}
	
	public int getHeight() {
		return (int) Hooks.selector.bufferProvider.fields.get(height).getValue(reference);
	}

}
