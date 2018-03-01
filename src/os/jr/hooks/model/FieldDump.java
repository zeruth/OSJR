package os.jr.hooks.model;

import java.lang.reflect.Field;

import os.jr.game.RSGame;
import os.jr.hooks.Hooks;

public class FieldDump {

	public String className = "";
	public String refactoredName = "";
	public String fieldName = "";
	public Number multiplier;

	public FieldDump() {

	}

	public Object getValue(Object reference) {
		try {
			Class<?> c = RSGame.classLoader.loadClass(Hooks.classNames.get(className));
			Field f = c.getDeclaredField(fieldName);
			f.setAccessible(true);
			if (multiplier != null) {
				return (int) f.get(reference) * multiplier.intValue();
			} else {
				return f.get(reference);
			}
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Null field. This shouldn't happen ever.");
			System.out.println(className + ":" + refactoredName);
		}
		return null;

	}
}