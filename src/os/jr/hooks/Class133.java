package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class133 extends GameClass{
	
	public static final String Viewport_containsMouse = "Viewport_containsMouse";
	public static final String Viewport_mouseX = "Viewport_mouseX";
	public static final String Viewport_mouseY = "Viewport_mouseY";
	public static final String Viewport_false0 = "Viewport_false0";
	public static final String Viewport_entityCountAtMouse = "Viewport_entityCountAtMouse";
	public static final String Viewport_entityIdsAtMouse = "Viewport_entityIdsAtMouse";

	public Class133() {
		super(Hooks.classNames.get("class133"));
	}
	
	public boolean ViewportContainsMouse() {
		return (boolean) fields.get(Viewport_containsMouse).getValue(reference);
	}
	
	public int getViewportMousX() {
		return (int) fields.get(Viewport_mouseX).getValue(reference);
	}
	
	public int getViewportMousY() {
		return (int) fields.get(Viewport_mouseY).getValue(reference);
	}
	
	public boolean ViewportFalse0() {
		return (boolean) fields.get(Viewport_false0).getValue(reference);
	}
	
	public int getViewportEntityCountAtMouse() {
		return (int) fields.get(Viewport_entityCountAtMouse).getValue(reference);
	}
	
	public int[] getViewportEntityIDsAtMouse() {
		return (int[]) fields.get(Viewport_entityIdsAtMouse).getValue(reference);
	}

}