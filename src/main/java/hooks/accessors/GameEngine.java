package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class GameEngine extends RSClass {

	public GameEngine(Object reference) {
		this.reference = reference;
		if (Hooks.gameEngine != null) {
			this.fields = Hooks.gameEngine.fields;
			this.name = Hooks.gameEngine.name;
			this.obfuscatedName = Hooks.gameEngine.obfuscatedName;
		}
	}

	public int getFps() {
		return (int) getValue(getField("FPS"));
	}

}
