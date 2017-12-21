package os.jr.hooks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import os.jr.hooks.loader.GameClass;

public class ClassInfo extends GameClass {

	public static final String count = "count";
	public static final String type = "type";
	public static final String errorIdentifiers = "errorIdentifiers";
	public static final String fields_ = "fields";
	public static final String methods = "methods";
	public static final String args = "args";

	public ClassInfo() {
		super(Hooks.classNames.get("ClassInfo"));
	}

	public byte[][][] getArgs() {
		return (byte[][][]) Hooks.selector.classInfo.fields.get(args).getValue(reference);
	}

	public int getCount() {
		return (int) Hooks.selector.classInfo.fields.get(count).getValue(reference);
	}

	public int[] getErrorIdentifiers() {
		return (int[]) Hooks.selector.classInfo.fields.get(errorIdentifiers).getValue(reference);
	}

	public Field[] getFields() {
		return (Field[]) Hooks.selector.classInfo.fields.get(fields_).getValue(reference);
	}

	public Method[] getMethods() {
		return (Method[]) Hooks.selector.classInfo.fields.get(fields_).getValue(reference);
	}

	public int[] getType() {
		return (int[]) Hooks.selector.classInfo.fields.get(type).getValue(reference);
	}
}
