package os.jr.hooks.loader;

import java.lang.reflect.Field;

import os.jr.game.RSGame;
import os.jr.utils.Utils;

public class FieldDump {

	public String className = "";
	public String refactoredName = "";
	public String fieldName = "";
	public Number multiplier;

	public FieldDump() {

	}

	public Object getValue(Object reference) {
		try {
			Object o;
			if (multiplier != null) {
				Field f = RSGame.classLoader.loadClass(Utils.getClassbyName(className).obfuscatedName)
						.getDeclaredField(fieldName);
				f.setAccessible(true);
				o = ((int) f.get(reference)) * multiplier.intValue();
			} else {
				Field f = RSGame.classLoader.loadClass(Utils.getClassbyName(className).obfuscatedName)
						.getDeclaredField(fieldName);
				f.setAccessible(true);
				o = f.get(reference);
			}
			return o;
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| ClassNotFoundException e) {
			System.out.println("Client hooks outdated. Please update from github or update hooks yourself.");
			System.out.println("Running without hooks.");
			RSGame.outdated = true;
			e.printStackTrace();
		}
		return null;
	}
}