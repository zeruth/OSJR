package os.jr.hooks;

import os.jr.game.GameFrame;
import os.jr.game.Reflector;
import os.jr.game.accessors.Client;

public class HookUpdater {
	
	static Thread t = new Thread(new Runnable() {
		
		@Override
		public void run() {
			while (true!=false) {
				Client.client = HookLoader.client;
				Client c = Reflector.getClient();
				if (c.getLoginState()==30) {
					Client.loggedIn=true;
				}
				if (Client.loggedIn) {
					GameFrame.changeName(c.getLocalPlayer().getName());
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	});
	
	public static void init() {
		t.start();
	}

}
