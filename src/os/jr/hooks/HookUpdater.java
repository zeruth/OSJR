package os.jr.hooks;

import os.jr.game.RSGame;

public class HookUpdater {
	public static long lastCacheRunTime = 0;
	static long sleeptime = 150;

	static Thread t = new Thread(new Runnable() {

		@SuppressWarnings("deprecation")
		@Override
		public void run() {

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
						if (lastCacheRunTime>50)
							System.out.println(
									"[Warning] Time to run last Hooks cache: (ms) "
											+lastCacheRunTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	});

	public static void anyStateHooks() {
		Client c = Hooks.selector.client;
		// int i = c.getLoginState();
	}

	public static void init() {
		t.start();
	}

	public static void loggedInHooks() {
		//Put checks that require a player to be logged in
		// here.
	}

}
