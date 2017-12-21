package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class SoundEffect extends GameClass {

	public SoundEffect(Object reference) {
		super(Hooks.classNames.get("SoundEffect"));
		this.reference = reference;
	}

}
