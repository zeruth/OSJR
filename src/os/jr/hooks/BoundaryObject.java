package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class BoundaryObject extends GameClass{

	public BoundaryObject() {
		super("ev");
		String boundaryObject = "ev";
		this.fields.put("BoundaryObject_ID", new GameField("d", boundaryObject, 18406019));
		this.fields.put("BoundaryObject_Flags", new GameField("d", boundaryObject, 1731653373));
		this.fields.put("BoundaryObject_Plane", new GameField("d", boundaryObject, 1808888379));
		this.fields.put("BoundaryObject_Height", new GameField("d", boundaryObject, 1080317993));
		this.fields.put("BoundaryObject_LocalX", new GameField("d", boundaryObject, -1854590965));
		this.fields.put("BoundaryObject_LocalY", new GameField("d", boundaryObject, -1987614443));
		this.fields.put("BoundaryObject_Orientation", new GameField("d", boundaryObject, 1749495747));
		this.fields.put("BoundaryObject_Render", new GameField("d", boundaryObject));
		this.fields.put("BoundaryObject_Render2", new GameField("d", boundaryObject));
	}

}
