package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Rasteriser extends GameClass {

	public static final String rasterizer = "ky";
	public static final String field_Pixels = "ad";
	public static final String field_Width = "ag";
	public static final String field_Height = "ak";

	public Rasteriser() {
		super(rasterizer);
		this.fields.put("Rasterizer_Pixels", new GameField(field_Pixels, rasterizer));
		this.fields.put("Rasterizer_Width", new GameField(field_Width, rasterizer));
		this.fields.put("Rasterizer_Height", new GameField(field_Height, rasterizer));
	}

}
