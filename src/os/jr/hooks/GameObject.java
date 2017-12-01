package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class GameObject extends GameClass {

	public static final String gameObject = "et";
	public static final String field_Render = "u";
	public static final String field_ID = "s";
	public static final String field_Flags = "n";
	public static final String field_Orientation = "z";
	public static final String field_Plane = "a";
	public static final String field_Height = "w";
	public static final String field_WorldX = "e";
	public static final String field_WorldY = "k";
	public static final String field_LocalX = "t";
	public static final String field_LocalY = "g";
	public static final String field_OffsetX = "f";
	public static final String field_OffsetY = "j";

	public static final int field_ID_multiplier = 1044473627;
	public static final int field_Flags_multiplier = 195247177;
	public static final int field_Orientation_multiplier = 1672836637;
	public static final int field_Plane_multiplier = -1866751847;
	public static final int field_Height_multiplier = 1840593029;
	public static final int field_WorldX_multiplier = 1087761421;
	public static final int field_WorldY_multiplier = 1063628249;
	public static final int field_LocalX_multiplier = 1610249375;
	public static final int field_LocalY_multiplier = 19135965;
	public static final int field_OffsetX_multiplier = 1511254367;
	public static final int field_OffsetY_multiplier = 235575925;

	public GameObject() {
		super(gameObject);
		this.fields.put("GameObject_Render", new GameField(field_Render, gameObject));
		this.fields.put("GameObject_ID", new GameField(field_ID, gameObject, field_ID_multiplier));
		this.fields.put("GameObject_Flags", new GameField(field_Flags, gameObject, field_Flags_multiplier));
		this.fields.put("GameObject_Orientation",
				new GameField(field_Orientation, gameObject, field_Orientation_multiplier));
		this.fields.put("GameObject_Plane", new GameField(field_Plane, gameObject, field_Plane_multiplier));
		this.fields.put("GameObject_Height", new GameField(field_Height, gameObject, field_Height_multiplier));
		this.fields.put("GameObject_WorldX", new GameField(field_WorldX, gameObject, field_WorldX_multiplier));
		this.fields.put("GameObject_WorldY", new GameField(field_WorldY, gameObject, field_WorldY_multiplier));
		this.fields.put("GameObject_LocalX", new GameField(field_LocalX, gameObject, field_LocalX_multiplier));
		this.fields.put("GameObject_LocalY", new GameField(field_LocalY, gameObject, field_LocalY_multiplier));
		this.fields.put("GameObject_OffsetX", new GameField(field_OffsetX, gameObject, field_OffsetX_multiplier));
		this.fields.put("GameObject_OffsetY", new GameField(field_OffsetY, gameObject, field_OffsetY_multiplier));
	}

}
