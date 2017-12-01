package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class ImageRGB extends GameClass {

	public static final String imageRGB = "ks";
	public static final String field_Pixels = "a";
	public static final String field_Width = "w";
	public static final String field_Height = "e";
	public static final String field_MaxWidth = "z";
	public static final String field_MaxHeight = "t";

	public ImageRGB() {
		super(imageRGB);
		this.fields.put("ImageRGB_Pixels", new GameField(field_Pixels, imageRGB));
		this.fields.put("ImageRGB_Width", new GameField(field_Width, imageRGB));
		this.fields.put("ImageRGB_Height", new GameField(field_Height, imageRGB));
		this.fields.put("ImageRGB_MaxWidth", new GameField(field_MaxWidth, imageRGB));
		this.fields.put("ImageRGB_MaxHeight", new GameField(field_MaxHeight, imageRGB));
	}

}
