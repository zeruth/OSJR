package os.jr.hooks;

import os.jr.hooks.model.GameField;

public class Widget extends Node {

	public static final String widget = "hz";
	public static final String field_Name = "cg";
	public static final String field_Text = "br";
	public static final String field_WidgetID = "i";
	public static final String field_ParentID = "ac";
	public static final String field_ItemID = "el";
	public static final String field_InvIDs = "eh";
	public static final String field_StackSizes = "ei";
	public static final String field_ItemAmount = "eb";
	public static final String field_Actions = "cw";
	public static final String field_ActionType = "q";
	public static final String field_Type = "m";
	public static final String field_IsHidden = "aw";
	public static final String field_AbsoluteX = "ab";
	public static final String field_AbsoluteY = "ad";
	public static final String field_RelativeX = "as";
	public static final String field_RelativeY = "aq";
	public static final String field_ScrollX = "al";
	public static final String field_ScrollY = "ay";
	public static final String field_Width = "ax";
	public static final String field_Height = "at";
	public static final String field_Children = "ey";
	public static final String field_BoundsIndex = "en";

	public static final int field_WidgetID_multiplier = 1180637085;
	public static final int field_ParentID_multiplier = 1222259003;
	public static final int field_ItemID_multiplier = -655869141;
	public static final int field_ItemAmount_multiplier = 306061293;
	public static final int field_ActionType_multiplier = 413006143;
	public static final int field_Type_multiplier = -615721927;
	public static final int field_AbsoluteX_multiplier = -942933619;
	public static final int field_AbsoluteY_multiplier = -520769527;
	public static final int field_RelativeX_multiplier = -2118483697;
	public static final int field_RelativeY_multiplier = 330328389;
	public static final int field_ScrollX_multiplier = -1206701085;
	public static final int field_ScrollY_multiplier = 579088909;
	public static final int field_Width_multiplier = 1913265447;
	public static final int field_Height_multiplier = -510787749;
	public static final int field_BoundsIndex_multiplier = -767002277;

	public Widget() {
		super(widget);
		this.fields.put("Widget_Name", new GameField(field_Name, widget));
		this.fields.put("Widget_Text", new GameField(field_Text, widget));
		this.fields.put("Widget_WidgetID", new GameField(field_WidgetID, widget, field_WidgetID_multiplier));
		this.fields.put("Widget_ParentID", new GameField(field_ParentID, widget, field_ParentID_multiplier));
		this.fields.put("Widget_ItemID", new GameField(field_ItemID, widget, field_ItemID_multiplier));
		this.fields.put("Widget_InvIDs", new GameField(field_InvIDs, widget));
		this.fields.put("Widget_StackSizes", new GameField(field_StackSizes, widget));
		this.fields.put("Widget_ItemAmount", new GameField(field_ItemAmount, widget, field_ItemAmount_multiplier));
		this.fields.put("Widget_Actions", new GameField(field_Actions, widget));
		this.fields.put("Widget_ActionType", new GameField(field_ActionType, widget, field_ActionType_multiplier));
		this.fields.put("Widget_Type", new GameField(field_Type, widget, field_Type_multiplier));
		this.fields.put("Widget_IsHidden", new GameField(field_IsHidden, widget));
		this.fields.put("Widget_AbsoluteX", new GameField(field_AbsoluteX, widget, field_AbsoluteX_multiplier));
		this.fields.put("Widget_AbsoluteY", new GameField(field_AbsoluteY, widget, field_AbsoluteY_multiplier));
		this.fields.put("Widget_RelativeX", new GameField(field_RelativeX, widget, field_RelativeX_multiplier));
		this.fields.put("Widget_RelativeY", new GameField(field_RelativeY, widget, field_RelativeY_multiplier));
		this.fields.put("Widget_ScrollX", new GameField(field_ScrollX, widget, field_ScrollX_multiplier));
		this.fields.put("Widget_ScrollY", new GameField(field_ScrollY, widget, field_ScrollY_multiplier));
		this.fields.put("Widget_Width", new GameField(field_Width, widget, field_Width_multiplier));
		this.fields.put("Widget_Height", new GameField(field_Height, widget, -field_Height_multiplier));
		this.fields.put("Widget_Children", new GameField(field_Children, widget));
		this.fields.put("Widget_BoundsIndex", new GameField(field_BoundsIndex, widget, field_BoundsIndex_multiplier));
	}

}
