package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Item extends GameClass {

	public static final String item = "cg";
	public static final String field_ID = "a";
	public static final String field_StackSizes = "w";

	public static final int field_ID_multiplier = 485193461;
	public static final int field_StackSizes_multiplier = -1501899501;

	public Item() {
		super(item);
		this.fields.put("Item_ID", new GameField(field_ID, item, field_ID_multiplier));
		this.fields.put("Item_StackSizes", new GameField(field_StackSizes, item, field_StackSizes_multiplier));
	}

	public Item(Object reference) {
		super(item);
		this.reference = reference;
		this.fields.put("Item_ID", new GameField(field_ID, item, field_ID_multiplier));
		this.fields.put("Item_StackSizes", new GameField(field_StackSizes, item, field_StackSizes_multiplier));
	}

}
