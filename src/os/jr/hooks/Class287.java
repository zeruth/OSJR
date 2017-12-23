package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class287 extends GameClass{
	
	public static final String NetCache_responseArchiveBuffer = "NetCache_responseArchiveBuffer";

	public Class287() {
		super(Hooks.classNames.get("class287"));
	}
	
	public Buffer NetCache_responseArchiveBuffer() {
		return new Buffer(fields.get(NetCache_responseArchiveBuffer).getValue(reference));
	}

}