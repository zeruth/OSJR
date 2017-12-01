package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class WallDecoration extends GameClass {

	public static final String wallDecoration = "eq";
	public static final String field_ID = "j";
	public static final String field_Flags = "x";
	public static final String field_Plane = "a";
	public static final String field_Height = "u";
	public static final String field_LocalX = "w";
	public static final String field_LocalY = "e";
	public static final String field_RelativeX = "z";
	public static final String field_RelativeY = "t";
	public static final String field_Orientation = "k";
	public static final String field_Renderable = "f";
	public static final String field_Renderable2 = "g";

	public static final int field_ID_multiplier = 1258761623;
	public static final int field_Flags_multiplier = 1479818253;
	public static final int field_Plane_multiplier = 714609933;
	public static final int field_Height_multiplier = 116232835;
	public static final int field_LocalX_multiplier = -635706115;
	public static final int field_LocalY_multiplier = -554820235;
	public static final int field_RelativeX_multiplier = -337797081;
	public static final int field_RelativeY_multiplier = 1852052911;
	public static final int field_Orientation_multiplier = 600979589;

	public WallDecoration() {
		super(wallDecoration);
		this.fields.put("WallDecoration_ID", new GameField(field_ID, wallDecoration, field_ID_multiplier));
		this.fields.put("WallDecoration_Flags", new GameField(field_Flags, wallDecoration, field_Flags_multiplier));
		this.fields.put("WallDecoration_Plane", new GameField(field_Plane, wallDecoration, field_Plane_multiplier));
		this.fields.put("WallDecoration_Height", new GameField(field_Height, wallDecoration, field_Height_multiplier));
		this.fields.put("WallDecoration_LocalX", new GameField(field_LocalX, wallDecoration, field_LocalX_multiplier));
		this.fields.put("WallDecoration_LocalY", new GameField(field_LocalY, wallDecoration, field_LocalY_multiplier));
		this.fields.put("WallDecoration_RelativeX",
				new GameField(field_RelativeX, wallDecoration, field_RelativeX_multiplier));
		this.fields.put("WallDecoration_RelativeY",
				new GameField(field_RelativeY, wallDecoration, field_RelativeY_multiplier));
		this.fields.put("WallDecoration_Orientation",
				new GameField(field_Orientation, wallDecoration, field_Orientation_multiplier));
		this.fields.put("WallDecoration_Renderable", new GameField(field_Renderable, wallDecoration));
		this.fields.put("WallDecoration_Renderable2", new GameField(field_Renderable2, wallDecoration));
	}

}
