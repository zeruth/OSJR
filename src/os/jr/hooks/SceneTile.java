package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class SceneTile extends GameClass {

	public static final String sceneTile = "ez";
	public static final String field_BoundaryObject = "t";
	public static final String field_SceneTileObject = "h";
	public static final String field_GameObject = "c";
	public static final String field_WallDecoration = "f";
	public static final String field_GroundDecoration = "g";
	public static final String field_LocalX = "w";
	public static final String field_LocalY = "e";
	public static final String field_Plane = "k";

	public static final int field_LocalX_multiplier = -695857629;
	public static final int field_LocalY_multiplier = 1267689537;
	public static final int field_Plane_multiplier = -721315981;

	public SceneTile() {
		super(sceneTile);
		this.fields.put("SceneTile_BoundaryObject", new GameField(field_BoundaryObject, sceneTile));
		this.fields.put("SceneTile_SceneTileObject", new GameField(field_SceneTileObject, sceneTile));
		this.fields.put("SceneTile_GameObject", new GameField(field_GameObject, sceneTile));
		this.fields.put("SceneTile_WallDecoration", new GameField(field_WallDecoration, sceneTile));
		this.fields.put("SceneTile_GroundDecoration", new GameField(field_GroundDecoration, sceneTile));
		this.fields.put("SceneTile_LocalX", new GameField(field_LocalX, sceneTile, field_LocalX_multiplier));
		this.fields.put("SceneTile_LocalY", new GameField(field_LocalY, sceneTile, field_LocalY_multiplier));
		this.fields.put("SceneTile_Plane", new GameField(field_Plane, sceneTile, field_Plane_multiplier));
	}

}
