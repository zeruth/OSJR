package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class287 extends RSClass{
	
	public static final String NetCache_responseArchiveBuffer = "NetCache_responseArchiveBuffer";

	public Class287() {
		super(Hooks.classNames.get("class287"));
	}
	
	public Buffer NetCache_responseArchiveBuffer() {
		return new Buffer(getField(NetCache_responseArchiveBuffer).getValue(reference));
	}

}