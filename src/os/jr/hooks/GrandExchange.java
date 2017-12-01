package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class GrandExchange extends GameClass {

	public static final String grandExchange = "r";
	public static final String field_Status = "a";
	public static final String field_ItemID = "w";
	public static final String field_Price = "e";
	public static final String field_Quantity = "k";
	public static final String field_Transferred = "u";
	public static final String field_Spent = "z";
	public static final String field_QueryIDs = null;

	public static final int field_ItemID_multiplier = 420374037;
	public static final int field_Price_multiplier = -940633443;
	public static final int field_Quantity_multiplier = -1993245439;
	public static final int field_Transferred_multiplier = -616978795;
	public static final int field_Spent_multiplier = 300076227;

	public GrandExchange() {
		super("f");
		String grandExchange = "f";
		this.fields.put("TradingPost_Status", new GameField("d", grandExchange));
		this.fields.put("TradingPost_ItemID", new GameField("x", grandExchange));
		this.fields.put("TradingPost_Price", new GameField("k", grandExchange));
		this.fields.put("TradingPost_Quantity", new GameField("z", grandExchange));
		this.fields.put("TradingPost_Transferred", new GameField("v", grandExchange));
		this.fields.put("TradingPost_Spent", new GameField("m", grandExchange));
		// this.fields.put("TradingPost_QueryIDs", new GameField("b", grandExchange));
		// N/A
	}

}
