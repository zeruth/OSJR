package hooks.model;

import java.lang.reflect.Field;

import game.Game;

public class RSClass {

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
		System.out.println("Shouldnt happen");
		return null;
	}

	public Object getValue(RSField f) {
		try {
			if (this.reference == null)
				this.reference = Game.applet;
			if (f.multiplier != null) {
				Field field = Game.jarLoader.loadClass(this.obfuscatedName).getDeclaredField(f.obfuscatedName);
				field.setAccessible(true);
				if (field.get(this.reference) == null) {
					return null;
				}
				return (int) (field.get(this.reference)) * f.multiplier.intValue();
			}

			Field field = Game.jarLoader.loadClass(this.obfuscatedName).getDeclaredField(f.obfuscatedName);
			field.setAccessible(true);
			return field.get(this.reference);
		} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException
				| SecurityException | ClassNotFoundException e) {
			if (Game.debug)
				e.printStackTrace();
		}
		return null;
	}
}