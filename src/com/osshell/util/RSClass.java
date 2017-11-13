package com.osshell.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Hashtable;


public class RSClass {
	private String refactoredName;
	private String obfuscatedName;
	private Class<?> clasz;

	private Hashtable<String, RSMethod> methods;
	private Hashtable<String, RSField> fields;

	public RSField getField(String name) {
		return fields.get(name);
	}

	public RSMethod getMethod(String name) {
		return methods.get(name);
	}

	public String getRefactoredName() {
		return this.refactoredName;
	}

	public String getObfuscatedName() {
		return this.obfuscatedName;
	}

	public Hashtable<String, RSMethod> getMethods() {
		return this.methods;
	}

	public void putMethod(RSMethod method) {
		this.methods.put(method.getRefactoredName(), method);
	}

	public Class<?> getClasz() {
		return clasz;
	}

	public Hashtable<String, RSField> getFields() {
		return this.fields;
	}

	public void putField(RSField field) {
		this.fields.put(field.getRefactoredName(), field);
	}

	public void putField(String refactoredName, Class<?> clasz, String name, int multiplier) {
		RSField field = null;
		if (clasz == null) {
			clasz = this.clasz;
		}
		
		try {
			Field f = getField(clasz, name);
			f.setAccessible(true);
			field = new RSField(refactoredName, f, multiplier);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (field != null) {
			System.out.println("Added field " + refactoredName + " to " + this.refactoredName);
			this.fields.put(field.getRefactoredName(), field);
		} else {
			System.out.println("Unable to load field " + refactoredName + " -> " + name);
		}

	}

	public void putMethod(String refactoredName, Class<?> clasz, String name, Class<?>[] parameterTypes, Object[] parameters) {
		RSMethod method = null;
		if (clasz == null) {
			clasz = this.clasz;
		}
		
		try {
			method = new RSMethod(refactoredName, getMethod(clasz, name, parameterTypes), parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (method != null) {
			System.out.println("Added method " + refactoredName + " to " + this.refactoredName);
			this.methods.put(method.getRefactoredName(), method);
		} else {
			System.out.println("Unable to load method " + refactoredName + " -> " + name);
		}

	}

	private static Field getField(Class clazz, String fieldName) throws NoSuchFieldException {
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			Class superClass = clazz.getSuperclass();
			if (superClass == null) {
				throw e;
			} else {
				return getField(superClass, fieldName);
			}
		}
	}

	private static Method getMethod(Class clazz, String methodName, Class... parameterTypes) throws NoSuchMethodException {
		try {
			return clazz.getDeclaredMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			Class superClass = clazz.getSuperclass();
			if (superClass == null) {
				throw e;
			} else {
				return getMethod(superClass, methodName, parameterTypes);
			}
		}
	}

	public void clearFields() {
		this.fields.clear();
	}

	public RSClass(String refactoredName, String obfuscatedName, Class<?> clasz) {
		this.refactoredName = refactoredName;
		this.obfuscatedName = obfuscatedName;
		this.fields = new Hashtable<String, RSField>();
		this.methods = new Hashtable<String, RSMethod>();
		this.clasz = clasz;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(refactoredName + " -> " + obfuscatedName + "\r\n");
		for (RSField field : fields.values()) {
			sb.append("\t" + field.toString() + "\r\n");
		}
		for (RSMethod method : methods.values()) {
			sb.append("\t" + method.toString() + "\r\n");
		}
		return sb.toString();
	}

}