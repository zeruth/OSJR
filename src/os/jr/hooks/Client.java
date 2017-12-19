package os.jr.hooks;

import os.jr.hooks.model.GameClass;

public class Client extends GameClass{
	
	public static final String loginState = "loginState";

	public Client(Object reference) {
		super(Hooks.classNames.get("Client"));
		this.reference=reference;
	}
	
	public int getLoginState() {
		return (int) fields.get(loginState).getValue(reference);
	}
	
	public Player getLocalPlayer() {
		return Hooks.selector.urlRequest.getLocalPlayer();
	}
	
	public boolean isLoggedOn() {
		return (getLoginState()==10);
	}

}
