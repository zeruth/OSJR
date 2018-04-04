package hooks.model;

import java.lang.reflect.Field;

import game.Game;

public class RSClass {
	
	Field field;

	public RSField[] fields;
	public String name;
	public String obfuscatedName;
	public Object reference;

	public RSClass() {

	}

	public RSField getField(String fieldName) {
		for (RSField f : this.fields) {
			if (f != null)
				if (f.name.compareTo(fieldName) == 0) {
					return f;
				}
		}
		return null;
	}

	public Object getValue(RSField f) {
		try {
			if (this.reference == null)
				this.reference = Game.applet;
			if (f.multiplier != null) {
				this.field = Game.jarLoader.loadClass(this.obfuscatedName).getDeclaredField(f.obfuscatedName);
				this.field.setAccessible(true);
				return (int) (this.field.get(this.reference)) * f.multiplier.intValue();
			}

			this.field = Game.jarLoader.loadClass(this.obfuscatedName).getDeclaredField(f.obfuscatedName);
			this.field.setAccessible(true);
			return this.field.get(this.reference);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| ClassNotFoundException e) {
			if (Game.debug)
				e.printStackTrace();
		}
		return null;
	}
}