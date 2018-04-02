package hooks.accessors;

import hooks.Hooks;
import hooks.helpers.LocalPoint;

public class Actor extends Renderable {

	public Actor(Object reference) {
		super(reference);
		if (Hooks.actor != null) {
			fields = Hooks.actor.fields;
			name = Hooks.actor.name;
			obfuscatedName = Hooks.actor.obfuscatedName;
		}
	}

	public LocalPoint getLocalLocation() {
		return new LocalPoint(getX(), getY());
	}

	public int getX() {
		return (int) getValue(getField("x"));
	}

	public int getY() {
		return (int) getValue(getField("y"));
	}
}
