package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Region extends GameClass{

	public Region() {
		super("ed");
		String region = "ed";
		this.fields.put("Region_SceneTiles", new GameField("cm", region));
		this.fields.put("Region_InteractableObjects", new GameField("cm", region));
	}

}
