package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class277 extends GameClass{
	
	public static final String cp1252AsciiExtension = "cp1252AsciiExtension";

	public Class277() {
		super(Hooks.classNames.get("class277"));
	}

	public char[] cp1252AsciiExtension() {
		return (char[]) fields.get(cp1252AsciiExtension).getValue(reference);
	}
}