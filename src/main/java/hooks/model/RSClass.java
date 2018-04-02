package hooks.model;

import java.lang.reflect.Field;

import game.Game;
import game.LoaderWindow;

public class RSClass {

	public RSField[] fields;
	public String name;
	public String obfuscatedName;
	public Object reference;

	public RSClass() {

	}

	public RSField getField(String fieldName) {
		for (RSField f : fields) {
			if (f != null)
				if (f.name.compareTo(fieldName) == 0) {
					return f;
				}
		}
		return null;
	}

	public Object getValue(RSField f) {
		try {
			if (reference == null)
				reference = Game.applet;
			if (f.multiplier != null) {
				Field ff = Game.jarLoader.loadClass(obfuscatedName).getDeclaredField(f.obfuscatedName);
				ff.setAccessible(true);
				return (int) (ff.get(reference)) * f.multiplier.intValue();
			}

			Field ff = Game.jarLoader.loadClass(obfuscatedName).getDeclaredField(f.obfuscatedName);
			ff.setAccessible(true);
			return ff.get(reference);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| ClassNotFoundException e) {
			if (LoaderWindow.game.debug)
				e.printStackTrace();
		}
		return null;
	}
}