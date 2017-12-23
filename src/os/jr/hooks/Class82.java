package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class82 extends RSClass{
	
	public static final String scriptLocalStrings = "scriptLocalStrings";
	public static final String SHAPE_VERTICES = "SHAPE_VERTICES";
	public static final String intStack = "intStack";
	public static final String intStackSize = "intStackSize";
	public static final String scriptStringStack = "scriptStringStack";
	public static final String scriptStackCount = "scriptStackCount";
	public static final String scriptStack = "scriptStack";

	public Class82() {
		super(Hooks.classNames.get("class82"));
	}
	
	public String[] getScriptLocalStrings() {
		return (String[]) getField(scriptLocalStrings).getValue(reference);
	}
	
	public int[][] SHAPE_VERTICES() {
		return (int[][]) getField(SHAPE_VERTICES).getValue(reference);
	}
	
	public int[] getIntStack() {
		return (int[]) getField(SHAPE_VERTICES).getValue(reference);
	}
	
	public int getIntStackSize() {
		return (int) getField(intStackSize).getValue(reference);
	}
	
	public String[] getScriptStringStack() {
		return (String[]) getField(scriptStringStack).getValue(reference);
	}
	
	public int getScriptStackCount() {
		return (int) getField(scriptStackCount).getValue(reference);
	}
	
	public ScriptState[] getScriptStack() {
		Object[] os = (Object[]) getField(scriptStack).getValue(reference);
		ScriptState[] scriptStack = new ScriptState[os.length];
		int i = 0;
		for (Object o : os) {
			scriptStack[i] = new ScriptState(o);
			i++;
		}
		return scriptStack;
	}

}