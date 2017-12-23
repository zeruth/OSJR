package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class RenderOverview extends GameClass {

	public RenderOverview(Object reference) {
		super(Hooks.classNames.get("RenderOverview"));
		this.reference = reference;
	}

}
