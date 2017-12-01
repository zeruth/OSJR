package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class CollisionMap extends GameClass {

	public static final String collisionMap = "fp";
	public static final String field_Width = "an";
	public static final String field_Height = "ac";
	public static final String field_Adjacency = "aw";

	public static final int field_Width_multiplier = 1741198449;
	public static final int field_Height_multiplier = 457443903;

	public CollisionMap() {
		super(collisionMap);
		this.fields.put("CollisionMap_Width", new GameField(field_Width, collisionMap, field_Width_multiplier));
		this.fields.put("CollisionMap_Height", new GameField(field_Height, collisionMap, field_Height_multiplier));
		this.fields.put("CollisionMap_Adjacency", new GameField(field_Adjacency, collisionMap));
	}

}
