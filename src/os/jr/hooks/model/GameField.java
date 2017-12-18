package os.jr.hooks.model;

import java.lang.reflect.Field;

import os.jr.boot.Boot;
import os.jr.game.RSGame;

public class GameField {

	public String fieldName;
	public String parentClass;
	public int multiplier = 1;

	public GameField(String fieldName, String parentClass) {
		this.fieldName = fieldName;
		this.parentClass = parentClass;
	}

	public GameField(String fieldName, String parentClass, int multiplier) {
		this.fieldName = fieldName;
		this.parentClass = parentClass;
		this.multiplier = multiplier;
	}

	public Object getValue(Object reference) {
		try {
			Object o;
			if (multiplier != 1) {
				Field f = RSGame.classLoader.loadClass(parentClass).getDeclaredField(fieldName);
				f.setAccessible(true);
				o = ((int) f.get(reference)) * multiplier;
			} else {
				Field f = RSGame.classLoader.loadClass(parentClass).getDeclaredField(fieldName);
				f.setAccessible(true);
				o = f.get(reference);
			}
			return o;
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| ClassNotFoundException e) {
			System.out.println("Client hooks outdated. Please update from github or update hooks yourself.");
			System.out.println("Running without hooks.");
			Boot.outdated = true;
			e.printStackTrace();
		}
		return null;
	}
}
