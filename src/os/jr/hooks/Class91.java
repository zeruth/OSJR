package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class91 extends GameClass{
	
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
		return new IndexedSprite(fields.get(landMapFileIds).getValue(reference));
	}
	
	public int getLoginWindowX() {
		return (int) fields.get(loginWindowX).getValue(reference);
	}
	
	public int getLoadingBarPercentage() {
		return (int) fields.get(loadingBarPercentage).getValue(reference);
	}
	
	public String getLoadingText() {
		return (String) fields.get(loadingText).getValue(reference);
	}
	
	public int getLoginIndex() {
		return (int) fields.get(loginIndex).getValue(reference);
	}
	
	public String getLogin_response0() {
		return (String) fields.get(Login_response0).getValue(reference);
	}
	
	public String getLoginMessage1() {
		return (String) fields.get(loginMessage1).getValue(reference);
	}
	
	public String getLoginMessage2() {
		return (String) fields.get(loginMessage2).getValue(reference);
	}
	
	public String getLoginMessage3() {
		return (String) fields.get(loginMessage3).getValue(reference);
	}

	public String getUsername() {
		return (String) fields.get(username).getValue(reference);
	}
	
	public String getPassword() {
		return (String) fields.get(password).getValue(reference);
	}
	
	public boolean getLogin_isUsernameRemembered() {
		return (boolean) fields.get(Login_isUsernameRemembered).getValue(reference);
	}
	
	public boolean getWorldSelectShown() {
		return (boolean) fields.get(worldSelectShown).getValue(reference);
	}
	
	public int[] getLandMapFileIds() {
		return (int[]) fields.get(landMapFileIds).getValue(reference);
	}

}