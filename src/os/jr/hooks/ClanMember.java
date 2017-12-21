package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class ClanMember extends GameClass{
	
	public static final String username = "username";
	public static final String world = "world";
	public static final String rank = "rank";

	public ClanMember() {
		super(Hooks.classNames.get("ClanMember"));
	}
	
	public String getUsername() {
		return (String) Hooks.selector.clanMember.fields.get(username).getValue(reference);
	}
	
	public int getWorld() {
		return (int) Hooks.selector.clanMember.fields.get(world).getValue(reference);
	}
	
	public byte getRank() {
		return (byte) Hooks.selector.clanMember.fields.get(rank).getValue(reference);
	}

}
