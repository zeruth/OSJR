package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class ClanMember extends RSClass {

	public static final String username = "username";
	public static final String world = "world";
	public static final String rank = "rank";

	public ClanMember() {
		super(Hooks.classNames.get("ClanMember"));
	}

	public byte getRank() {
		return (byte) getField(rank).getValue(reference);
	}

	public String getUsername() {
		return (String) getField(username).getValue(reference);
	}

	public int getWorld() {
		return (int) getField(world).getValue(reference);
	}

}
