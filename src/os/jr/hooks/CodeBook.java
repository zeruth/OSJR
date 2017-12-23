package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class CodeBook extends RSClass {
	
	public static final String dimensions = "dimensions";
	public static final String entries = "entries";
	public static final String entryLengths = "entryLengths";
	public static final String valueVector = "valueVector";

	public CodeBook(Object reference) {
		super(Hooks.classNames.get("CodeBook"));
		this.reference = reference;
	}
	
	public int getDimensions() {
		return (int) getField(dimensions).getValue(reference);
	}
	
	public int getEntries() {
		return (int) getField(entries).getValue(reference);
	}
	
	public int[] getEntryLengths() {
		return (int[]) getField(entryLengths).getValue(reference);
	}
	
	public float[][] getValueVector() {
		return (float[][]) getField(entryLengths).getValue(reference);
	}

}
