package hooks.accessors;

import hooks.Hooks;
import hooks.helpers.LocalPoint;

public class Actor extends Renderable {

	public Actor(Object reference) {
		super(reference);
		if (Hooks.actor != null) {
			this.fields = Hooks.actor.fields;
			this.name = Hooks.actor.name;
			this.obfuscatedName = Hooks.actor.obfuscatedName;
		}
	}

	public LocalPoint getLocalLocation() {
		return new LocalPoint(getX(), getY());
	}

	public int getX() {
		return (int) getValue(getField("x")); //$NON-NLS-1$
	}

	public int getY() {
		return (int) getValue(getField("y")); //$NON-NLS-1$
	}
}
