package os.jr.hooks.updater;

import os.jr.boot.Boot;
import os.jr.game.GameFrame;
import os.jr.hooks.Client;
import os.jr.hooks.Hooks;
import os.jr.hooks.Node;

public class HookUpdater {
	public static Client client;
	public static Node node;
	public static long lastCacheRunTime = 0;
	static long sleeptime = 250;

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
						sleeptime -= lastCacheRunTime;
						if (sleeptime<50) {
							System.out.println("Cache thread clogged. <50 ms of free time per cycle.");
							System.out.println("Increasing sleeptime to " + sleeptime + "(ms)");
							sleeptime=600;
						}
						Thread.sleep(sleeptime);
						
						//Start Hook caching
						
						Long cacheTimerStart = System.currentTimeMillis();
						if (Hooks.selector.client.isLoggedIn()) {
							
							Client c = Hooks.selector.client;
							c.realLevels = c.getRealLevels();
							c.currentLevels = c.getCurrentLevels();
							c.experiences = c.getExperiences();
							c.loginState = c.getLoginState();
							c.gameState = c.getGameState();
							c.baseY = c.getBaseY();
							c.baseX = c.getBaseX();
							c.cameraX = c.getCameraX();
							c.cameraY = c.getCameraY();
							c.cameraZ = c.getCameraZ();
							c.cameraPitch = c.getCameraPitch();
							c.cameraYaw = c.getCameraYaw();
							c.CurrentWorld = c.getCurrentWorld();
							c.Energy = c.getEnergy();
							c.Weight = c.getWeight();
							
							GameFrame.changeName(Hooks.selector.client.getLocalPlayer().getName());
						} else {
							GameFrame.changeName(null);
						}
						lastCacheRunTime = System.currentTimeMillis() - cacheTimerStart;
						System.out.println("Time to run last Hooks cache: (ms) "+lastCacheRunTime);
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
