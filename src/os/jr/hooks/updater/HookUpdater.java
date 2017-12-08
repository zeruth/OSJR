package os.jr.hooks.updater;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import os.jr.boot.Boot;
import os.jr.hooks.Client;
import os.jr.hooks.Hooks;
import os.jr.hooks.Node;
import os.jr.utils.Dumper;

public class HookUpdater {
	public static Client client;
	public static Node node;
	public static long lastCacheRunTime = 0;
	static long sleeptime = 150;

	static Thread t = new Thread(new Runnable() {

		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			Client c = Hooks.selector.client;
			
			while (true != false) {
				{
					if (Boot.outdated) {
						Boot.changeName("Hookless-Mode");
						t.stop();
					}
					try {
						
						Thread.sleep(sleeptime);
						
						Dumper.dumpLocalNPCS(c.getLocalNPCs());

						//Start Hook caching
						Long cacheTimerStart = System.currentTimeMillis();
						
						//Any-state hooks
						c.loginState = c.getLoginState();
						c.gameState = c.getGameState();
						c.CurrentWorld = c.getCurrentWorld();
						c.Energy = c.getEnergy();
						c.Weight = c.getWeight();
						c.realLevels = c.getRealLevels();
						c.currentLevels = c.getCurrentLevels();
						c.experiences = c.getExperiences();
						c.baseY = c.getBaseY();
						c.baseX = c.getBaseX();
						c.cameraX = c.getCameraX();
						c.cameraY = c.getCameraY();
						c.cameraZ = c.getCameraZ();
						c.cameraPitch = c.getCameraPitch();
						c.cameraYaw = c.getCameraYaw();
						
						//Logged-in hooks
						if (Hooks.selector.client.isLoggedIn()) {
							
							Boot.changeName(Hooks.selector.client.getLocalPlayer().getName());
							

						} else {
							Boot.changeName(Boot.VERSION);
						}
						lastCacheRunTime = System.currentTimeMillis() - cacheTimerStart;
						//System.out.println("Time to run last Hooks cache: (ms) "+lastCacheRunTime);
						//System.out.println("Example - Login State: "+Hooks.selector.client.loginState);
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
