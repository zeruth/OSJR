package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class IndexedRGB extends GameClass{

	public IndexedRGB() {
		super("kl");
		String indexedRGB = "kl";
		this.fields.put("IndexedRGB_Pixels", new GameField("x", indexedRGB));	
		this.fields.put("IndexedRGB_Palette", new GameField("d", indexedRGB));	
	}

}
