package os.jr.hooks;

public class BoundingBox3D extends BoundingBox{
	
	public static final String int1 = "int1";
	public static final String int2 = "int2";
	public static final String int3 = "int3";
	public static final String int4 = "int4";
	public static final String int5 = "int5";
	public static final String int6 = "int6";
	public static final String color = "color";

	public BoundingBox3D() {
		super(Hooks.classNames.get("BoundingBox3D"));
	}
	
	public int getInt1() {
		return (int) Hooks.selector.boundingBox3D.fields.get(int1).getValue(reference);
	}
	
	public int getInt2() {
		return (int) Hooks.selector.boundingBox3D.fields.get(int2).getValue(reference);
	}
	
	public int getInt3() {
		return (int) Hooks.selector.boundingBox3D.fields.get(int3).getValue(reference);
	}
	
	public int getInt4() {
		return (int) Hooks.selector.boundingBox3D.fields.get(int4).getValue(reference);
	}
	
	public int getInt5() {
		return (int) Hooks.selector.boundingBox3D.fields.get(int5).getValue(reference);
	}
	
	public int getInt6() {
		return (int) Hooks.selector.boundingBox3D.fields.get(int6).getValue(reference);
	}
	
	public int getColor() {
		return (int) Hooks.selector.boundingBox3D.fields.get(color).getValue(reference);
	}

}
