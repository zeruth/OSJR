package os.jr.hooks.model;

import java.lang.reflect.Field;
import java.util.HashMap;

import os.jr.game.Reflector;

public class GameClass {
	public String className;
	public HashMap<String, GameField> fields = new HashMap<String, GameField>();
	public HashMap<String, GameField> allFields = new HashMap<String, GameField>();
	
	public GameClass(String classIdentifier) {
		this.className = classIdentifier;
		try {
			for (Field f : Reflector.classLoader.loadClass(classIdentifier).getFields()) {
				this.allFields.put(f.getName(), new GameField(f.getName(), classIdentifier));
			}
		} catch (SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object getFieldValue(String identifier, Object reference) throws NoSuchFieldException, SecurityException,
			ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		Class<?> c = Reflector.classLoader.loadClass(className);
		GameField gf = fields.get(identifier);
		Field f = c.getField(gf.fieldName);
		if (gf.multiplier!=1) {
			return ((int)f.get(reference)*gf.multiplier);
		}
		return f.get(reference);
	}
}
