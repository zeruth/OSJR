package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class192 extends GameClass{
	
	public static final String clanChatCount = "clanChatCount";
	public static final String listFetcher = "listFetcher";

	public Class192() {
		super(Hooks.classNames.get("class192"));
	}
	
	public int getClanChatCount() {
		return (int) fields.get(clanChatCount).getValue(reference);
	}
	
	public UrlRequest getListFetcher() {
		return new UrlRequest(fields.get(clanChatCount).getValue(reference));
	}
}