package os.jr.hooks.updater;

import os.jr.game.RSGame;
import os.jr.hooks.Client;
import os.jr.hooks.Hooks;
import os.jr.utils.Utils;

public class HookUpdater {
	public static long lastCacheRunTime = 0;
	static long sleeptime = 150;

	static Thread t = new Thread(new Runnable() {

		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			Utils.makeXPforLevel();

			while (true != false) {
				{
					if (RSGame.outdated) {
						t.stop();
					}
					try {

						Thread.sleep(sleeptime);
						// Start Hook caching
						Long cacheTimerStart = System.currentTimeMillis();

						anyStateHooks();
						loggedInHooks();

						lastCacheRunTime = System.currentTimeMillis() - cacheTimerStart;
						// System.out.println("Time to run last Hooks cache: (ms) "+lastCacheRunTime);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	});

	public static void anyStateHooks() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void init() {
		t.start();
	}

	public static void loggedInHooks() {
		Client c = Hooks.selector.client;
		try {
			if (c.isLoggedOn()) {
				System.out.println(c.getLocalPlayer().getX());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
