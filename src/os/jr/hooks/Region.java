package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Region extends GameClass {

	public static final String region = "eh";
	public static final String field_SceneTiles = "z";
	public static final String field_InteractableObjects = "g";

	public Region() {
		super(region);
		this.fields.put("Region_SceneTiles", new GameField(field_SceneTiles, region));
		this.fields.put("Region_InteractableObjects", new GameField(field_InteractableObjects, region));
	}

}
