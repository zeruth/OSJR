package os.jr.hooks;

import java.nio.ByteBuffer;

import os.jr.hooks.loader.RSClass;

public class DirectByteBuffer extends RSClass {

	public static final String buffer = "buffer";

	public DirectByteBuffer() {
		super(Hooks.classNames.get("DirectByteBuffer"));
	}

	public ByteBuffer getBuffer() {
		return (ByteBuffer) getField(buffer).getValue(reference);
	}

	byte[] get() {
		ByteBuffer b = getBuffer();
		byte[] var1 = new byte[b.capacity()];
		b.position(0);
		b.get(var1);
		return var1;
	}

	void put(byte[] var1) {
		ByteBuffer b = getBuffer();
		b = ByteBuffer.allocateDirect(var1.length);
		b.position(0);
		b.put(var1);
	}
}
