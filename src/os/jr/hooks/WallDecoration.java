package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class WallDecoration extends GameClass{

	public WallDecoration() {
		super("eg");
		String wallDecoration = "eg";
		this.fields.put("WallDecoration_ID", new GameField("r", wallDecoration, 406457547));
		this.fields.put("WallDecoration_Flags", new GameField("l", wallDecoration, 1402112071));
		this.fields.put("WallDecoration_Plane", new GameField("d", wallDecoration, 150031225));
		this.fields.put("WallDecoration_Height", new GameField("v", wallDecoration, -1672912555));
		this.fields.put("WallDecoration_LocalX", new GameField("k", wallDecoration, 1149072573));
		this.fields.put("WallDecoration_LocalY", new GameField("x", wallDecoration, -2041529573));
		this.fields.put("WallDecoration_RelativeX", new GameField("m", wallDecoration, 986105179));
		this.fields.put("WallDecoration_RelativeY", new GameField("b", wallDecoration, 1103225915));
		this.fields.put("WallDecoration_Orientation", new GameField("z", wallDecoration, -793043469));
		this.fields.put("WallDecoration_Renderable", new GameField("t", wallDecoration));
		this.fields.put("WallDecoration_Renderable2", new GameField("p", wallDecoration));
	}

}
