package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class SceneTile extends GameClass{

	public SceneTile() {
		super("en");
		String sceneTile = "en";
		this.fields.put("SceneTile_BoundaryObject", new GameField("b", sceneTile));
		this.fields.put("SceneTile_SceneTileObject", new GameField("o", sceneTile));
		this.fields.put("SceneTile_GameObject", new GameField("u", sceneTile));
		this.fields.put("SceneTile_WallDecoration", new GameField("t", sceneTile));
		this.fields.put("SceneTile_GroundDecoration", new GameField("p", sceneTile));
		this.fields.put("SceneTile_LocalX", new GameField("k", sceneTile, 1815659089));
		this.fields.put("SceneTile_LocalY", new GameField("x", sceneTile, -964365923));
		this.fields.put("SceneTile_Plane", new GameField("z", sceneTile, -1379576209));
	}

}
