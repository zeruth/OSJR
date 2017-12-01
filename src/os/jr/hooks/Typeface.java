package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Typeface extends GameClass {

	public static final String typeFace = "jd";
	public static final String field_CharacterPixels = "a";

	public Typeface() {
		super(typeFace);
		this.fields.put("Typeface_CharacterPixels", new GameField(field_CharacterPixels, typeFace));
	}

}
