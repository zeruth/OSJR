package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public abstract class AbstractByteBuffer extends GameClass{
	
	public static final String directBufferUnavailable = "directBufferUnavailable";

	public AbstractByteBuffer() {
		super(Hooks.classNames.get("AbstractByteBuffer"));
	}
	
	public boolean getDirectBufferUnavailable() {
		return (boolean) fields.get(directBufferUnavailable).getValue(reference);
	}

}
