package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Cache extends GameClass{

	public Cache() {
		super("gx");
		String cache = "gx";
		this.fields.put("Cache_HashTable", new GameField("z", cache));	
		this.fields.put("Cache_Queue", new GameField("v", cache));	
		this.fields.put("Cache_Remaining", new GameField("k", cache));	
		this.fields.put("Cache_Capacity", new GameField("x", cache));	
	}

}
