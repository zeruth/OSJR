package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class CollisionMap extends GameClass{

	public CollisionMap() {
		super("fb");
		String collisionMap = "fb";
		this.fields.put("CollisionMap_Width", new GameField("d", collisionMap, 1934361261));
		this.fields.put("CollisionMap_Height", new GameField("d", collisionMap, -1159264013));
		this.fields.put("CollisionMap_Adjacency", new GameField("d", collisionMap));
	}

}
