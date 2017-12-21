package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class CollisionData extends GameClass{

	public CollisionData(Object reference) {
		super(Hooks.classNames.get("CollisionData"));
		this.reference = reference;
	}

}
