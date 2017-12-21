package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class FileOnDisk extends GameClass{

	public FileOnDisk(Object reference) {
		super(Hooks.classNames.get("FileOnDisk"));
		this.reference = reference;
	}

}
