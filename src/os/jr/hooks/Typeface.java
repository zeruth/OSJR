package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Typeface extends GameClass{

	public Typeface() {
		super("jq");
		String typeface = "jq";
		this.fields.put("Typeface_CharacterPixels", new GameField("d", typeface));	
	}

}
