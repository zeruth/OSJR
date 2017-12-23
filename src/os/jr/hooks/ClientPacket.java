package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class ClientPacket extends RSClass {
	
	public static final String menuY = "menuY";
	public static final String packetId = "packetId";
	public static final String packetLength = "packetLength";

	public ClientPacket() {
		super(Hooks.classNames.get("ClientPacket"));
	}
	
	public int getMenuY() {
		return (int) getField(menuY).getValue(reference);
	}
	
	public int getPacketId() {
		return (int) getField(packetId).getValue(reference);
	}
	
	public int getPacketLength() {
		return (int) getField(packetLength).getValue(reference);
	}

}
