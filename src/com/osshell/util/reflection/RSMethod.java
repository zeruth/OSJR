package com.osshell.util.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RSMethod {
	private String refactoredName;
	private Method method;
	private Object[] parameters;

	public String getRefactoredName() {
		return this.refactoredName;
	}

	public Method getMethod() {
		return this.method;
	}

	/**
	 * 
	 * invokes the methods using the parameters declared before with some
	 * replaced with ones provided.
	 * 
	 * 
	 * @param obj
	 *            : the object to invoke a method on
	 * @param tokens
	 *            : the specific parameters we are passing in @param args
	 * @param args
	 *            : the parameters we are passing in
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Object invoke(Object obj, String[] tokens, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Object[] finalParameters = new Object[parameters.length];
		for (int j = 0; j < parameters.length; j++) {
			boolean replaced = false;
			if (parameters[j] instanceof String) {
				for (int i = 0; i < tokens.length; i++) {
					if (((String) parameters[j]).equals(tokens[i])) {
						finalParameters[j] = args[i];
						replaced = true;
						break;
					}
				}
			}
			if (!replaced) {
				finalParameters[j] = parameters[j];
			}

		}

		return method.invoke(obj, finalParameters);
	}

	public RSMethod(String refactoredName, Method method, Object[] parameters) {
		this.refactoredName = refactoredName;
		this.method = method;
		this.parameters = parameters;

		method.setAccessible(true);
	}

}
