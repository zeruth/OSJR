package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Renderable extends GameClass {

	public static final String renderable = "el";
	public static final String field_ModelHeight = "cw";

	public static final int field_ModelHeight_multiplier = -1204322527;

	public Renderable() {
		super(renderable);
		this.fields.put("Renderable_ModelHeight",
				new GameField(field_ModelHeight, renderable, field_ModelHeight_multiplier));
	}

}
