package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Cacheable extends GameClass{

	public Cacheable() {
		super("gt");
		String cacheable = "gt";
		this.fields.put("Cacheable_Next", new GameField("ci", cacheable));
		this.fields.put("Cacheable_Prev", new GameField("cp", cacheable));
	}

}
