package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class IndexData extends GameClass{

	public IndexData(Object reference) {
		super(Hooks.classNames.get("IndexData"));
		this.reference = reference;
	}

}
