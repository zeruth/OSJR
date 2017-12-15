package os.jr.hooks;

import os.jr.hooks.model.GameField;

public class Cacheable extends Node {

	public static final String cacheable = "gi";
	public static final String field_Next = "cg";
	public static final String field_Prev = "co";

	public Cacheable() {
		super(cacheable);
		this.fields.put("Cacheable_Next", new GameField(field_Next, cacheable));
		this.fields.put("Cacheable_Prev", new GameField(field_Prev, cacheable));
	}

}
