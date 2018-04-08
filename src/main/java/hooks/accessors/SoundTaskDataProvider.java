package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class SoundTaskDataProvider extends RSClass {
	Player localPlayer;

	public SoundTaskDataProvider(Object reference) {
		this.reference = reference;
		if (Hooks.soundTaskDataProvider != null) {
			this.fields = Hooks.soundTaskDataProvider.fields;
			this.name = Hooks.soundTaskDataProvider.name;
			this.obfuscatedName = Hooks.soundTaskDataProvider.obfuscatedName;
		}
	}

	public Player getLocalPlayer() {
		this.reference = null;
		this.localPlayer = new Player(getValue(getField("localPlayer")));
		return this.localPlayer;
	}
}
