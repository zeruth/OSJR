package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class ImageRGB extends GameClass{

	public ImageRGB() {
		super("ky");
		String imageRGB = "ky";
		this.fields.put("ImageRGB_Pixels", new GameField("d", imageRGB));	
		this.fields.put("ImageRGB_Width", new GameField("x", imageRGB));	
		this.fields.put("ImageRGB_Height", new GameField("k", imageRGB));	
		this.fields.put("ImageRGB_MaxWidth", new GameField("m", imageRGB));	
		this.fields.put("ImageRGB_MaxHeight", new GameField("b", imageRGB));	
	}

}
