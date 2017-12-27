package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Enum extends RSClass {
	
	public static final String EnumDefinition_indexCache = "EnumDefinition_indexCache";
	public static final String EnumDefinition_cached = "EnumDefinition_cached";
	public static final String keyType = "keyType";
	public static final String valType = "valType";
	public static final String defaultString = "defaultString";
	public static final String defaultInt = "defaultInt";
	public static final String size = "size";
	public static final String keys = "keys";
	public static final String intVals = "intVals";
	public static final String stringVals = "stringVals";

	public Enum() {
		super(Hooks.classNames.get("Enum"));
	}
	
	public IndexDataBase EnumDefinition_indexCache() {
		return new IndexDataBase(getField(EnumDefinition_indexCache).getValue(reference));
	}
	
	public NodeCache EnumDefinition_cached() {
		return new NodeCache(getField(EnumDefinition_cached).getValue(reference));
	}
	
	public char getKeyType() {
		return (char) getField(keyType).getValue(reference);
	}
	
	public char getValType() {
		return (char) getField(valType).getValue(reference);
	}
	
	public String getDefaultString() {
		return (String) getField(defaultString).getValue(reference);
	}
	
	public int getDefaultInt() {
		return (int) getField(defaultInt).getValue(reference);
	}
	
	public int getSize() {
		return (int) getField(size).getValue(reference);
	}
	
	public int[] getKeys() {
		return (int[]) getField(keys).getValue(reference);
	}
	
	public int[] getIntVals() {
		return (int[]) getField(intVals).getValue(reference);
	}
	
	public String[] getStringVals() {
		return (String[]) getField(stringVals).getValue(reference);
	}

}
