package os.jr.hooks.updater;

import os.jr.boot.Boot;
import os.jr.game.GameFrame;
import os.jr.hooks.Client;
import os.jr.hooks.Hooks;
import os.jr.hooks.Node;

public class HookUpdater {
	public static Client client;
	public static Node node;

	static Thread t = new Thread(new Runnable() {

		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			while (true != false) {
				{
					if (Boot.outdated) {
						GameFrame.changeName("Hookless-Mode");
						t.stop();
					}
					try {
						Thread.sleep(60);
						if (Hooks.selector.client.isLoggedIn()) {
							GameFrame.changeName(Hooks.selector.client.getLocalPlayer().getName());

						} else {
							GameFrame.changeName(null);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	});

	public static void init() {
		t.start();
	}

}
