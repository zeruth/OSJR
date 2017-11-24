package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Renderable extends GameClass{

	public Renderable() {
		super("es");
		String renderable = "es";
		this.fields.put("Renderable_ModelHeight", new GameField("cm", renderable, 1642849179));
	}

}
