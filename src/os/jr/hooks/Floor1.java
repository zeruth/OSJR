package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Floor1 extends RSClass {
	
	public static final String RANGES = "RANGES";
	public static final String xList = "xList";
	public static final String yList = "yList";
	public static final String multiplier = "multiplier";
	public static final String paritionClassList = "paritionClassList";
	public static final String classDimensions = "classDimensions";
	public static final String classSubClasses = "classSubClasses";
	public static final String classMasterbooks = "classMasterbooks";
	public static final String subclassBooks = "subclassBooks";

	public Floor1(Object reference) {
		super(Hooks.classNames.get("Floor1"));
		this.reference = reference;
	}
	
	public int[] RANGES( ) {
		return (int[]) getField(RANGES).getValue(reference);
	}
	
	public int[] getXList() {
		return (int[]) getField(xList).getValue(reference);
	}
	
	public int[] getYList() {
		return (int[]) getField(yList).getValue(reference);
	}
	
	public int getMultiplier() {
		return (int) getField(multiplier).getValue(reference);
	}
	
	public int[] getParitionClassList() {
		return (int[]) getField(paritionClassList).getValue(reference);
	}
	
	public int[] getClassDimensions() {
		return (int[]) getField(classDimensions).getValue(reference);
	}
	
	public int[] getClassSubClasses() {
		return (int[]) getField(classSubClasses).getValue(reference);
	}
	
	public int[] getClassMasterbooks() {
		return (int[]) getField(classMasterbooks).getValue(reference);
	}
	
	public int[][] getSubclassBooks() {
		return (int[][]) getField(subclassBooks).getValue(reference);
	}
}
