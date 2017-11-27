package os.jr.hooks.updater;

import os.jr.boot.Boot;
import os.jr.game.GameFrame;
import os.jr.game.Reflector;
import os.jr.hooks.Client;
import os.jr.hooks.Hooks;
import os.jr.hooks.Node;

public class HookUpdater {
	public static Client client;
	public static Node node;

	static Thread t = new Thread(new Runnable() {

		@Override
		public void run() {
			while (true != false) {
				{
					try {
						Thread.sleep(200);
						if (Hooks.selector.client.isLoggedIn()) {
							GameFrame.changeName(Hooks.selector.client.getLocalPlayer().getName());
						}
						else {
							GameFrame.changeName(null);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


					//t.stop();
				}
			}

		}
	});

	public static void init() {
		t.start();
	}

}
