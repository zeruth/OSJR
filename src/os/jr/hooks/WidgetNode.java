package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class WidgetNode extends GameClass{

	public WidgetNode() {
		super("br");
		String widgetNode = "br";
		this.fields.put("WidgetNode_ID", new GameField("d", widgetNode, 942543977));
	}

}
