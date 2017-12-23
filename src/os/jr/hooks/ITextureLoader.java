package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class ITextureLoader extends RSClass {

	public ITextureLoader(Object reference) {
		super(Hooks.classNames.get("ITextureLoader"));
		this.reference = reference;
	}

}
