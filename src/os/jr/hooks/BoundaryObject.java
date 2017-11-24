package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class BoundaryObject extends GameClass{

	public BoundaryObject() {
		super("ev");
		String boundaryObject = "ev";
		this.fields.put("BoundaryObject_ID", new GameField("t", boundaryObject, 18406019));
		this.fields.put("BoundaryObject_Flags", new GameField("k", boundaryObject, 1731653373));
		this.fields.put("BoundaryObject_Plane", new GameField("b", boundaryObject, 1808888379));
		this.fields.put("BoundaryObject_Height", new GameField("x", boundaryObject, 1080317993));
		this.fields.put("BoundaryObject_LocalX", new GameField("s", boundaryObject, -1854590965));
		this.fields.put("BoundaryObject_LocalY", new GameField("r", boundaryObject, -1987614443));
		this.fields.put("BoundaryObject_Orientation", new GameField("g", boundaryObject, 1749495747));
		this.fields.put("BoundaryObject_Render", new GameField("f", boundaryObject));
		this.fields.put("BoundaryObject_Render2", new GameField("u", boundaryObject));
	}

}
