package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class WidgetNode extends GameClass {

	public static final String widgetNode = "bt";
	public static final String field_ID = "a";

	public static final int field_ID_multiplier = 1515870281;

	public WidgetNode() {
		super(widgetNode);
		this.fields.put("WidgetNode_ID", new GameField(field_ID, widgetNode, field_ID_multiplier));
	}

}
