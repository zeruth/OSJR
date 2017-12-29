package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class FontTypeFace extends RSClass {
	
	public static final String modIcons = "modIcons";
	public static final String strikeRGB = "strikeRGB";
	public static final String underlineRGB = "underlineRGB";
	public static final String prevShadeRGB = "prevShadeRGB";
	public static final String shadow = "shadow";
	public static final String prevColorRGB = "prevColorRGB";
	public static final String color = "color";
	public static final String gylphs = "gylphs";
	public static final String gylphHeights = "gylphHeights";
	public static final String glyphWidths = "glyphWidths";
	public static final String horizontalOffsets = "horizontalOffsets";
	public static final String verticalOffsets = "verticalOffsets";
	public static final String verticalSpace = "verticalSpace";
	public static final String minSpacing = "minSpacing";
	public static final String maxSpacing = "maxSpacing";

	public FontTypeFace() {
		super(Hooks.classNames.get("FontTypeFace"));
	}
	
	public IndexedSprite getModIcons() {
		return new IndexedSprite(getField(modIcons).getValue(reference));
	}
	
	public int getStrikeRGB() {
		return (int) getField(strikeRGB).getValue(reference);
	}
	
	public int getUnderlineRGB() {
		return (int) getField(underlineRGB).getValue(reference);
	}
	
	public int getPrevShadeRGB() {
		return (int) getField(prevShadeRGB).getValue(reference);
	}
	
	public int getShadow() {
		return (int) getField(shadow).getValue(reference);
	}
	
	public int getprevColorRGB() {
		return (int) getField(prevColorRGB).getValue(reference);
	}
	
	public int getColor() {
		return (int) getField(color).getValue(reference);
	}
	
	public int[][] getGylphs() {
		return (int[][]) getField(gylphs).getValue(reference);
	}
	
	public int[] getGylphHeights() {
		return (int[]) getField(gylphHeights).getValue(reference);
	}
	
	public int[] getGlyphWidths() {
		return (int[]) getField(glyphWidths).getValue(reference);
	}
	
	public int[] getHorizontalOffsets() {
		return (int[]) getField(horizontalOffsets).getValue(reference);
	}
	
	public int[] getVerticalOffsets() {
		return (int[]) getField(verticalOffsets).getValue(reference);
	}
	
	public int getVerticalSpace() {
		return (int) getField(verticalSpace).getValue(reference);
	}
	
	public int getMinSpacing() {
		return (int) getField(minSpacing).getValue(reference);
	}
	
	public int getMaxSpacing() {
		return (int) getField(maxSpacing).getValue(reference);
	}

}
