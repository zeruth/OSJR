package os.jr.hooks;

import os.jr.hooks.model.GameField;

public class Actor extends Renderable{
	
	public static final String x = "x";
	public static final String y = "y";

	public Actor() {
		super(Hooks.classNames.get("Actor"));
	}
	
	public Actor(String className) {
		super(className);
	}
	
	public int getX() {
		return (int) Hooks.selector.actor.fields.get(x).getValue(reference);
	}
	
	public int getY() {
		return (int) Hooks.selector.actor.fields.get(y).getValue(reference);
	}

}
