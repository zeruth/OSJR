package os.jr.hooks.model;

import java.lang.reflect.Field;
import java.util.HashMap;

import os.jr.boot.Boot;
import os.jr.game.Reflector;

public class GameClass {
	public String className;
	public HashMap<String, GameField> fields = new HashMap<String, GameField>();
	public HashMap<String, GameField> allFields = new HashMap<String, GameField>();
	public Object reference;

	public GameClass(String classIdentifier) {
		this.className = classIdentifier;
		try {
			try {
				Reflector.classLoader.loadClass(classIdentifier);
			} catch (ClassNotFoundException e) {
				System.out.println("Client hooks outdated. Please update from github or update hooks yourself.");
				System.out.println("Running without hooks.");
				Boot.outdated = true;
				e.printStackTrace();
				return;
			}
			for (Field f : Reflector.classLoader.loadClass(classIdentifier).getFields()) {
				this.allFields.put(f.getName(), new GameField(f.getName(), classIdentifier));
			}
		} catch (SecurityException | ClassNotFoundException e) {
			System.out.println("Client hooks outdated. Please update from github or update hooks yourself.");
			System.out.println("Running without hooks.");
			Boot.outdated = true;
			e.printStackTrace();
		}
	}

	public Object getFieldValue(String identifier, Object reference) {
		Class<?> c = null;

		try {
			c = Reflector.classLoader.loadClass(className);
			GameField gf = fields.get(identifier);
			Field f = c.getDeclaredField(gf.fieldName);
			f.setAccessible(true);
			if (gf.multiplier != 1) {
				return ((int) f.get(reference) * gf.multiplier);
			}
			return f.get(reference);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return c;

	}
}
