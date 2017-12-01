package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Rasteriser3D extends GameClass {

	public static final String rasteriser3D = "es";
	public static final String field_ShadowDecay = "d";
	public static final String field_SineTable = "p";
	public static final String field_CosineTable = "ab";

	public Rasteriser3D() {
		super(rasteriser3D);
		this.fields.put("Rasterizer3D_ShadowDecay", new GameField("w", rasteriser3D));
		this.fields.put("Rasterizer3D_SineTable", new GameField("a", rasteriser3D));
		this.fields.put("Rasterizer3D_CosineTable", new GameField("ah", rasteriser3D));
	}

}
