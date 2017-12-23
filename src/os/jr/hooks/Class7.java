package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class7 extends RSClass{
	
	public static final String drawBoundingBoxes3D = "drawBoundingBoxes3D";
	public static final String drawBoundingBoxes2D = "drawBoundingBoxes2D";
	public static final String drawObjectGeometry2D = "drawObjectGeometry2D";
	public static final String boundingBox3DDrawMode = "boundingBox3DDrawMode";
	public static final String boundingBoxes = "boundingBoxes";
	public static final String slArrowSprites = "slArrowSprites";

	public Class7() {
		super(Hooks.classNames.get("class7"));
	}
	
	public boolean drawBoundingBoxes3D() {
		return (boolean) getField(drawBoundingBoxes3D).getValue(reference);
	}
	
	public boolean drawBoundingBoxes2D() {
		return (boolean) getField(drawBoundingBoxes2D).getValue(reference);
	}
	
	public boolean drawObjectGeometry2D() {
		return (boolean) getField(drawObjectGeometry2D).getValue(reference);
	}
	
	public Class11 getBoundingBox3DDrawMode() {
		return new Class11(getField(boundingBox3DDrawMode).getValue(reference));
	}
	
	public CombatInfoList getBoundingBoxes() {
		return new CombatInfoList(getField(boundingBoxes).getValue(reference));
	}
	
	public IndexedSprite[] getSlArrowSprites() {
		Object[] os = (Object[]) getField(slArrowSprites).getValue(reference);
		IndexedSprite[] slArrowSprites = new IndexedSprite[os.length];
		int i = 0;
		for (Object o : os) {
			slArrowSprites[i] = new IndexedSprite(o);
			i++;
		}
		return slArrowSprites;
	}

}