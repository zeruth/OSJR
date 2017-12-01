package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class FloorDecoration extends GameClass {

	public static final String floorDecoration = "dq";
	public static final String field_ID = "dq";
	public static final String field_Flags = "dq";
	public static final String field_LocalX = "dq";
	public static final String field_LocalY = "dq";
	public static final String field_Plane = "dq";
	public static final String field_Render = "dq";

	public static final int field_ID_multiplier = 1395110931;
	public static final int field_Flags_multiplier = 908974953;
	public static final int field_LocalX_multiplier = -1302060085;
	public static final int field_LocalY_multiplier = 326033797;
	public static final int field_Plane_multiplier = 950595223;

	public FloorDecoration() {
		super(floorDecoration);
		this.fields.put("FloorDecoration_ID", new GameField(field_ID, floorDecoration, field_ID_multiplier));
		this.fields.put("FloorDecoration_Flags", new GameField(field_Flags, floorDecoration, field_Flags_multiplier));
		this.fields.put("FloorDecoration_LocalX",
				new GameField(field_LocalX, floorDecoration, field_LocalX_multiplier));
		this.fields.put("FloorDecoration_LocalY",
				new GameField(field_LocalY, floorDecoration, field_LocalY_multiplier));
		this.fields.put("FloorDecoration_Plane", new GameField(field_Plane, floorDecoration, field_Plane_multiplier));
		this.fields.put("FloorDecoration_Render", new GameField(field_Render, floorDecoration));
	}

}
