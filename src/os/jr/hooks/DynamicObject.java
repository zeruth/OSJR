package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class DynamicObject extends RSClass {
	
	public static final String id = "id";
	public static final String type = "type";
	public static final String orientation = "orientation";
	public static final String level = "level";
	public static final String sceneX = "sceneX";
	public static final String sceneY = "sceneY";

	public DynamicObject(Object reference) {
		super(Hooks.classNames.get("DynamicObject"));
		this.reference = reference;
	}
	
	public int getId() {
		return (int) getField(id).getValue(reference);
	}
	
	public int getType() {
		return (int) getField(type).getValue(reference);
	}
	
	public int getOrientation() {
		return (int) getField(orientation).getValue(reference);
	}
	
	public int getLevel() {
		return (int) getField(level).getValue(reference);
	}
	
	public int getSceneX() {
		return (int) getField(sceneX).getValue(reference);
	}
	
	public int getSceneY() {
		return (int) getField(sceneY).getValue(reference);
	}

}
