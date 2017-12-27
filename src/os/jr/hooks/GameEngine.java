package os.jr.hooks;

import java.awt.Canvas;

import os.jr.hooks.loader.RSClass;

public class GameEngine extends RSClass {
	
	public static final String canvas = "canvas";
	public static final String shell = "shell";

	public GameEngine(Object reference) {
		super(Hooks.classNames.get("GameEngine"));
		this.reference = reference;
	}
	
	public Canvas getCanvas() {
		return (Canvas) getField(canvas).getValue(reference);
	}
	
	public GameEngine getShell() {
		return new GameEngine(getField(shell).getValue(reference));
	}

}
