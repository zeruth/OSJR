package os.jr.hooks.model;

import java.lang.reflect.Field;
import java.util.HashMap;

import os.jr.boot.Boot;
import os.jr.game.RSGame;

public class GameClass {
	public String obfuscatedName;
	public String refactoredName;
	public HashMap<String, GameField> fields = new HashMap<String, GameField>();
	public HashMap<String, GameField> allFields = new HashMap<String, GameField>();
	public Object reference;

	public GameClass(String obfuscatedName) {
		this.obfuscatedName = obfuscatedName;
		try {
			RSGame.classLoader.loadClass(obfuscatedName);
			for (Field f : RSGame.classLoader.loadClass(obfuscatedName).getFields()) {
				this.allFields.put(f.getName(), new GameField(f.getName(), obfuscatedName));
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
			c = RSGame.classLoader.loadClass(obfuscatedName);
			GameField gf = fields.get(identifier);
			Field f = c.getDeclaredField(gf.fieldName);
			f.setAccessible(true);
			if (gf.multiplier != 1) {
				return ((int) f.get(reference) * gf.multiplier);
			}
			return f.get(reference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;

	}
}
