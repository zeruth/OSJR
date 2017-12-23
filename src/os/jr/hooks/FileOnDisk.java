package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class FileOnDisk extends RSClass {

	public FileOnDisk(Object reference) {
		super(Hooks.classNames.get("FileOnDisk"));
		this.reference = reference;
	}

}
