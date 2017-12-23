package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class DecorativeObject extends RSClass {
	
	public static final String floor = "floor";
	public static final String x = "x";
	public static final String y = "y";
	public static final String renderFlag = "renderFlag";
	public static final String rotation = "rotation";
	public static final String offsetX = "offsetX";
	public static final String offsetY = "offsetY";
	public static final String renderable1 = "renderable1";
	public static final String renderable2 = "renderable2";
	public static final String hash = "hash";
	public static final String renderInfoBitPacked = "renderInfoBitPacked";

	public DecorativeObject(Object reference) {
		super(Hooks.classNames.get("DecorativeObject"));
		this.reference = reference;
	}
	
	public int getFloor() {
		return (int) getField(floor).getValue(reference);
	}
	
	public int getX() {
		return (int) getField(x).getValue(reference);
	}
	
	public int getY() {
		return (int) getField(y).getValue(reference);
	}
	
	public int getRenderFlag() {
		return (int) getField(renderFlag).getValue(reference);
	}
	
	public int getRotation() {
		return (int) getField(rotation).getValue(reference);
	}
	
	public int getOffsetX() {
		return (int) getField(offsetX).getValue(reference);
	}
	
	public int getOffsetY() {
		return (int) getField(offsetY).getValue(reference);
	}
	
	public Renderable getRenderable1() {
		return new Renderable(getField(renderable1).getValue(reference));
	}
	
	public Renderable getRenderable2() {
		return new Renderable(getField(renderable2).getValue(reference));
	}

	public int getHash() {
		return (int) getField(hash).getValue(reference);
	}
	
	public int getRenderInfoBitPacked() {
		return (int) getField(renderInfoBitPacked).getValue(reference);
	}
}
