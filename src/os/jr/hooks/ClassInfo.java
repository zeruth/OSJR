package os.jr.hooks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import os.jr.hooks.loader.RSClass;

public class ClassInfo extends RSClass {

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
		return (byte[][][]) Hooks.selector.classInfo.getField(args).getValue(reference);
	}

	public int getCount() {
		return (int) Hooks.selector.classInfo.getField(count).getValue(reference);
	}

	public int[] getErrorIdentifiers() {
		return (int[]) Hooks.selector.classInfo.getField(errorIdentifiers).getValue(reference);
	}

	public Field[] getFields() {
		return (Field[]) Hooks.selector.classInfo.getField(fields_).getValue(reference);
	}

	public Method[] getMethods() {
		return (Method[]) Hooks.selector.classInfo.getField(fields_).getValue(reference);
	}

	public int[] getType() {
		return (int[]) Hooks.selector.classInfo.getField(type).getValue(reference);
	}
}
