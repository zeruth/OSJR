package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Widget extends GameClass{

	public Widget() {
		super("hx");
		String widget = "hx";
		this.fields.put("Widget_Name", new GameField("ci", widget));	
		this.fields.put("Widget_Text", new GameField("by", widget));	
		this.fields.put("Widget_WidgetID", new GameField("s", widget, -525009403));	
		this.fields.put("Widget_ParentID", new GameField("am", widget, -939662049));	
		this.fields.put("Widget_ItemID", new GameField("es", widget, 1943890401));	
		this.fields.put("Widget_InvIDs", new GameField("ed", widget));	
		this.fields.put("Widget_StackSizes", new GameField("ee", widget));	
		this.fields.put("Widget_ItemAmount", new GameField("ev", widget, 792075027));	
		this.fields.put("Widget_Actions", new GameField("cm", widget));	
		this.fields.put("Widget_ActionType", new GameField("h", widget, 309039089));	
		this.fields.put("Widget_Type", new GameField("q", widget, 1216642255));	
		this.fields.put("Widget_IsHidden", new GameField("ag", widget));	
		this.fields.put("Widget_AbsoluteX", new GameField("ah", widget, 1408168051));	
		this.fields.put("Widget_AbsoluteY", new GameField("ak", widget, 1603582641));	
		this.fields.put("Widget_RelativeX", new GameField("aq", widget, 1330007417));	
		this.fields.put("Widget_RelativeY", new GameField("au", widget, 1700282541));	
		this.fields.put("Widget_ScrollX", new GameField("aw", widget, 1645568929));	
		this.fields.put("Widget_ScrollY", new GameField("ap", widget, 539683255));	
		this.fields.put("Widget_Width", new GameField("al", widget, 1303371013));	
		this.fields.put("Widget_Height", new GameField("ae", widget, -476989827));	
		this.fields.put("Widget_Children", new GameField("eu", widget));	
		this.fields.put("Widget_BoundsIndex", new GameField("et", widget, -1579751947));	
		}

}
