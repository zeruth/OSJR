package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Rasteriser extends GameClass{

	public Rasteriser() {
		super("kc");
		String rasterizer = "kc";
		this.fields.put("Rasterizer_Pixels", new GameField("ak", rasterizer));	
		this.fields.put("Rasterizer_Width", new GameField("aa", rasterizer));	
		this.fields.put("Rasterizer_Height", new GameField("ax", rasterizer));	
	}

}
