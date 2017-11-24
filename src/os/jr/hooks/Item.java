package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Item extends GameClass{

	public Item() {
		super("ci");
		String item = "ci";
		this.fields.put("Item_ID", new GameField("d", item, -1306463285));
		this.fields.put("Item_StackSizes", new GameField("x", item, 1252821907));
	}

}
