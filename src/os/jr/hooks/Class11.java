package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class11 extends RSClass{
	
	public static final String BoundingBox3DDrawMode_mouseOver = "BoundingBox3DDrawMode_mouseOver";
	public static final String BoundingBox3DDrawMode_all = "BoundingBox3DDrawMode_all";
	public static final String host = "host";

	public Class11(Object reference) {
		super(Hooks.classNames.get("class11"));
		this.reference = reference;
	}
	
	public final Class11 BoundingBox3DDrawMode_mouseOver() {
		return new Class11(getField(BoundingBox3DDrawMode_mouseOver).getValue(reference));
	}
	
	public final Class11 BoundingBox3DDrawMode_all() {
		return new Class11(getField(BoundingBox3DDrawMode_all).getValue(reference));
	}
	
	public String getHost() {
		return (String) getField(host).getValue(reference);
	}

}