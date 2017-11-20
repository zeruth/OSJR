package os.jr.hooks;

import os.jr.game.accessors.Client;
import os.jr.loader.GameFrame;
import os.jr.loader.Loader;

public class HookUpdater {
	
	static Thread t = new Thread(new Runnable() {
		
		@Override
		public void run() {
			while (true!=false) {
				Client.client = HookLoader.client;
				Client c = Loader.getClient();
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
