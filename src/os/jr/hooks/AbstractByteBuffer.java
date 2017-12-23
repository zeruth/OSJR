package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public abstract class AbstractByteBuffer extends RSClass {

	public static final String directBufferUnavailable = "directBufferUnavailable";

	public AbstractByteBuffer() {
		super(Hooks.classNames.get("AbstractByteBuffer"));
	}

	public boolean getDirectBufferUnavailable() {
		return (boolean) getField(directBufferUnavailable).getValue(reference);
	}

}
