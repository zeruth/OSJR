package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class ClanMember extends GameClass {

	public static final String username = "username";
	public static final String world = "world";
	public static final String rank = "rank";

	public ClanMember() {
		super(Hooks.classNames.get("ClanMember"));
	}

	public byte getRank() {
		return (byte) fields.get(rank).getValue(reference);
	}

	public String getUsername() {
		return (String) fields.get(username).getValue(reference);
	}

	public int getWorld() {
		return (int) fields.get(world).getValue(reference);
	}

}
