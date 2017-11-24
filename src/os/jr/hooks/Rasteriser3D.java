package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Rasteriser3D extends GameClass{

	public Rasteriser3D() {
		super("em");
		String rasterizer3D = "em";
		this.fields.put("Rasterizer3D_ShadowDecay", new GameField("w", rasterizer3D));	
		this.fields.put("Rasterizer3D_SineTable", new GameField("a", rasterizer3D));	
		this.fields.put("Rasterizer3D_CosineTable", new GameField("ah", rasterizer3D));	
	}

}
