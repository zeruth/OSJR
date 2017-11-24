package os.jr.hooks;

import os.jr.boot.Boot;
import os.jr.game.GameFrame;
import os.jr.game.Reflector;

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
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					GameFrame.changeName("-Fallback Mode-");
					t.stop();
				}
			}

		}
	});

	public static void init() {
		t.start();
	}

}
