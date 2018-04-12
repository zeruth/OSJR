package hooks.accessors;

import java.awt.Polygon;

import hooks.Hooks;
import hooks.helpers.LocalPoint;
import hooks.helpers.Perspective;

public class Actor extends Renderable {

	LocalPoint localLocation;
	int x;
	int y;
	Polygon tileAreaonScreen;

	public Actor(Object reference) {
		super(reference);
		if (Hooks.actor != null) {
			this.fields = Hooks.actor.fields;
			this.name = Hooks.actor.name;
			this.obfuscatedName = Hooks.actor.obfuscatedName;
		}
	}

	public LocalPoint getLocalLocation() {
		this.localLocation = new LocalPoint(getX(), getY());
		return this.localLocation;
	}

	public int getX() {
		this.x = (int) getValue(getField("x"));
		return this.x;
	}

	public int getY() {
		this.y = (int) getValue(getField("y"));
		return this.y;
	}

	public Polygon getTileAreaOnScreen() {
		this.tileAreaonScreen = Perspective.getCanvasTilePoly(Hooks.client, getLocalLocation());
		return this.tileAreaonScreen;
	}
}
