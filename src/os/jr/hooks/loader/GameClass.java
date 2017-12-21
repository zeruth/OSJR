package os.jr.hooks.loader;

import java.lang.reflect.Field;
import java.util.HashMap;

import os.jr.game.RSGame;
import os.jr.hooks.Hooks;
import os.jr.utils.Utils;

public class GameClass {
	public String obfuscatedName;
	public String refactoredName;
	public HashMap<String, FieldDump> fields = new HashMap<String, FieldDump>();
	public Object reference;

	public GameClass(String obfuscatedName) {
		this.obfuscatedName = obfuscatedName;
		this.refactoredName = Hooks.refactoredClassNames.get(obfuscatedName);
		try {
			RSGame.classLoader.loadClass(obfuscatedName);
		} catch (SecurityException | ClassNotFoundException e) {
			System.out.println("Client hooks outdated. Please update from github or update hooks yourself.");
			System.out.println("Running without hooks.");
			RSGame.outdated = true;
			e.printStackTrace();
		}
		if (Hooks.selector!=null) {
			GameClass gameClass = Utils.getClassbyName(this.refactoredName);
			if (gameClass!=null) {
				if (gameClass.fields!=null)
				this.fields = gameClass.fields;
			}
		}
	}

	public Object getFieldValue(String identifier, Object reference) {
		Class<?> c = null;
		try {
			c = RSGame.classLoader.loadClass(obfuscatedName);
			FieldDump gf = fields.get(identifier);
			Field f = c.getDeclaredField(gf.fieldName);
			f.setAccessible(true);
			if (gf.multiplier.intValue() != 1) {
				return ((int) f.get(reference) * gf.multiplier.intValue());
			}
			return f.get(reference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;

	}
}
