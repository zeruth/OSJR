package os.jr.hooks.model;

import java.lang.reflect.Field;

import os.jr.boot.Boot;
import os.jr.game.Reflector;

public class GameField {
	
	public String fieldName;
	public String parentClass;
	public int multiplier = 1;
	
	public GameField(String fieldName, String parentClass) {
		this.fieldName = fieldName;
		this.parentClass = parentClass;
	//System.out.println("Loaded Hook - Class: "+this.parentClass+" - Field: "+this.fieldName);
	}
	
	public GameField(String fieldName, String parentClass, int multiplier) {
		this.fieldName = fieldName;
		this.parentClass = parentClass;
		this.multiplier = multiplier;
		//System.out.println("Loaded Hook - Class: "+this.parentClass+" - Field: "+this.fieldName + " "+multiplier);
	}

	public Object getValue(Object reference) {
		try {
			Object o;
			if (multiplier!=1) {
				Field f = Reflector.classLoader.loadClass(parentClass).getDeclaredField(fieldName);
				f.setAccessible(true);
				o = ((int)f.get(reference))*multiplier;		
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
			Boot.outdated=true;
			e.printStackTrace();
		}
		return null;
	}
}
