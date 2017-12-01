package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class IndexedRGB extends GameClass {

	public static final String indexedRGB = "kg";
	public static final String field_Pixels = "w";
	public static final String field_Palette = "a";

	public IndexedRGB() {
		super(indexedRGB);
		this.fields.put("IndexedRGB_Pixels", new GameField(field_Pixels, indexedRGB));
		this.fields.put("IndexedRGB_Palette", new GameField(field_Palette, indexedRGB));
	}

}
