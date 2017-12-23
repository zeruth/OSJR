package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class91 extends RSClass{
	
	public static final String logoSprite = "logoSprite";
	public static final String loginWindowX = "loginWindowX";
	public static final String loadingBarPercentage = "loadingBarPercentage";
	public static final String loadingText = "loadingText";
	public static final String loginIndex = "loginIndex";
	public static final String Login_response0 = "Login_response0";
	public static final String loginMessage1 = "loginMessage1";
	public static final String loginMessage2 = "loginMessage2";
	public static final String loginMessage3 = "loginMessage3";
	public static final String username = "username";
	public static final String password = "password";
	public static final String Login_isUsernameRemembered = "Login_isUsernameRemembered";
	public static final String worldSelectShown = "worldSelectShown";
	public static final String landMapFileIds = "landMapFileIds";


	public Class91() {
		super(Hooks.classNames.get("class91"));
	}
	
	public IndexedSprite getLogoSprite() {
		return new IndexedSprite(getField(landMapFileIds).getValue(reference));
	}
	
	public int getLoginWindowX() {
		return (int) getField(loginWindowX).getValue(reference);
	}
	
	public int getLoadingBarPercentage() {
		return (int) getField(loadingBarPercentage).getValue(reference);
	}
	
	public String getLoadingText() {
		return (String) getField(loadingText).getValue(reference);
	}
	
	public int getLoginIndex() {
		return (int) getField(loginIndex).getValue(reference);
	}
	
	public String getLogin_response0() {
		return (String) getField(Login_response0).getValue(reference);
	}
	
	public String getLoginMessage1() {
		return (String) getField(loginMessage1).getValue(reference);
	}
	
	public String getLoginMessage2() {
		return (String) getField(loginMessage2).getValue(reference);
	}
	
	public String getLoginMessage3() {
		return (String) getField(loginMessage3).getValue(reference);
	}

	public String getUsername() {
		return (String) getField(username).getValue(reference);
	}
	
	public String getPassword() {
		return (String) getField(password).getValue(reference);
	}
	
	public boolean getLogin_isUsernameRemembered() {
		return (boolean) getField(Login_isUsernameRemembered).getValue(reference);
	}
	
	public boolean getWorldSelectShown() {
		return (boolean) getField(worldSelectShown).getValue(reference);
	}
	
	public int[] getLandMapFileIds() {
		return (int[]) getField(landMapFileIds).getValue(reference);
	}

}