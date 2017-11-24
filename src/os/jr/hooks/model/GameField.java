package os.jr.hooks.model;

import java.lang.reflect.Field;

import os.jr.game.Reflector;

public class GameField {
	
	public String fieldName;
	public String parentClass;
	public long multiplier = 1;
	
	public GameField(String fieldName, String parentClass) {
		this.fieldName = fieldName;
		this.parentClass = parentClass;
	//	System.out.println("Loaded Hook - Class: "+this.parentClass+" - Field: "+this.fieldName);
	}
	
	public GameField(String fieldName, String parentClass, long multiplier) {
		this.fieldName = fieldName;
		this.parentClass = parentClass;
		this.multiplier = multiplier;
		//System.out.println("Loaded Hook - Class: "+this.parentClass+" - Field: "+this.fieldName);
	}

	public Object getValue(Object reference) {
		try {
			Object o;
			if (multiplier!=1) {
				o = ((int)Reflector.classLoader.loadClass(parentClass).getField(fieldName).get(reference))*multiplier;		
			}
			else {
			//	System.out.println("parent "+parentClass);
			//	System.out.println("field "+fieldName);
				Field f = Reflector.classLoader.loadClass(parentClass).getDeclaredField(fieldName);
				f.setAccessible(true);
				o = f.get(reference);
			}
			return o;
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
