package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class FloorDecoration extends GameClass{

	public FloorDecoration() {
		super("dd");
		String floorDecoration = "dd";
		this.fields.put("FloorDecoration_ID", new GameField("v", floorDecoration, 610343311));
		this.fields.put("FloorDecoration_Flags", new GameField("m", floorDecoration, 158025097));
		this.fields.put("FloorDecoration_LocalX", new GameField("k", floorDecoration, -1426760087));
		this.fields.put("FloorDecoration_LocalY", new GameField("x", floorDecoration, -11860079));
		this.fields.put("FloorDecoration_Plane", new GameField("d", floorDecoration, -1683399343));
		this.fields.put("FloorDecoration_Render", new GameField("z", floorDecoration));
	}

}
