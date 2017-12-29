package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class FontName extends RSClass {
	
	public static final String FontName_plain11 = "FontName_plain11";
	public static final String FontName_plain12 = "FontName_plain12";
	public static final String FontName_bold12 = "FontName_bold12";
	public static final String indexCache15 = "indexCache15";

	public FontName(Object reference) {
		super(Hooks.classNames.get("FontName"));
		this.reference = reference;
	}
	
	public FontName FontName_plain11() {
		return new FontName(getField(FontName_plain11).getValue(reference));
	}
	
	public FontName FontName_plain12() {
		return new FontName(getField(FontName_plain12).getValue(reference));
	}
	
	public FontName FontName_bold12() {
		return new FontName(getField(FontName_bold12).getValue(reference));
	}
	
	public IndexData getIndexCache15() {
		return new IndexData(getField(indexCache15).getValue(reference));
	}

}
