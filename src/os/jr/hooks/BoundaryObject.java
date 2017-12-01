package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class BoundaryObject extends GameClass {

	public static final String boundaryObject = "eb";
	public static final String field_ID = "f";
	public static final String field_Flags = "g";
	public static final String field_Plane = "a";
	public static final String field_Height = "u";
	public static final String field_LocalX = "w";
	public static final String field_LocalY = "e";
	public static final String field_Orientation = "k";
	public static final String field_Render = "z";
	public static final String field_Render2 = "t";

	public static final int field_ID_multiplier = 2085641561;
	public static final int field_Flags_multiplier = 585357267;
	public static final int field_Plane_multiplier = -848426587;
	public static final int field_Height_multiplier = 529102943;
	public static final int field_LocalX_multiplier = -395897065;
	public static final int field_LocalY_multilier = 1588001219;
	public static final int field_Orientation_multiplier = -659812433;

	public BoundaryObject() {
		super(boundaryObject);
		this.fields.put("BoundaryObject_ID", new GameField(field_ID, boundaryObject, field_ID_multiplier));
		this.fields.put("BoundaryObject_Flags", new GameField(field_Flags, boundaryObject, field_Flags_multiplier));
		this.fields.put("BoundaryObject_Plane", new GameField(field_Plane, boundaryObject, field_Plane_multiplier));
		this.fields.put("BoundaryObject_Height", new GameField(field_Height, boundaryObject, field_Height_multiplier));
		this.fields.put("BoundaryObject_LocalX", new GameField(field_LocalX, boundaryObject, field_LocalX_multiplier));
		this.fields.put("BoundaryObject_LocalY", new GameField(field_LocalY, boundaryObject, field_LocalY_multilier));
		this.fields.put("BoundaryObject_Orientation",
				new GameField(field_Orientation, boundaryObject, field_Orientation_multiplier));
		this.fields.put("BoundaryObject_Render", new GameField(field_Render, boundaryObject));
		this.fields.put("BoundaryObject_Render2", new GameField(field_Render2, boundaryObject));
	}

}
