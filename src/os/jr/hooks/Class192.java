package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class192 extends RSClass{
	
	public static final String clanChatCount = "clanChatCount";
	public static final String listFetcher = "listFetcher";

	public Class192() {
		super(Hooks.classNames.get("class192"));
	}
	
	public int getClanChatCount() {
		return (int) getField(clanChatCount).getValue(reference);
	}
	
	public UrlRequest getListFetcher() {
		return new UrlRequest(getField(clanChatCount).getValue(reference));
	}
}