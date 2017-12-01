package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Cache extends GameClass {

	public static final String cache = "gu";
	public static final String field_Hashtable = "k";
	public static final String field_Queue = "u";
	public static final String field_Remaining = "e";
	public static final String field_Capacity = "w";

	public Cache() {
		super(cache);
		this.fields.put("Cache_HashTable", new GameField(field_Hashtable, cache));
		this.fields.put("Cache_Queue", new GameField(field_Queue, cache));
		this.fields.put("Cache_Remaining", new GameField(field_Remaining, cache));
		this.fields.put("Cache_Capacity", new GameField(field_Capacity, cache));
	}

}
