package os.jr.hooks.updater;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import os.jr.boot.Boot;
import os.jr.game.RSGame;
import os.jr.game.Skill;
import os.jr.hooks.Client;
import os.jr.hooks.Hooks;
import os.jr.hooks.Node;
import os.jr.ui.StatMonitor;
import os.jr.ui.Notes;
import os.jr.utils.Dumper;
import os.jr.utils.SettingsIo;
import os.jr.utils.Utils;

public class HookUpdater {
	public static Client client;
	public static Node node;
	public static long lastCacheRunTime = 0;
	static long sleeptime = 150;
	
	public static Client c;

	static Thread t = new Thread(new Runnable() {

		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			Utils.makeXPforLevel();
			c = Hooks.selector.client;
			
			while (true != false) {
				{
					if (Boot.outdated) {
						Boot.rsGame.changeName("Hookless-Mode");
						t.stop();
					}
					try {
						
						Thread.sleep(sleeptime);

						//Start Hook caching
						Long cacheTimerStart = System.currentTimeMillis();
						
						anyStateHooks();
						loggedInHooks();

						lastCacheRunTime = System.currentTimeMillis() - cacheTimerStart;
						//System.out.println("Time to run last Hooks cache: (ms) "+lastCacheRunTime);
						
						cycleDumpers();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	});
	
	public static void anyStateHooks() {
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
		
		if (Notes.frame!=null) {
			if (Notes.getTextArea().getText().compareTo(Notes.notes)!=0) {
				Notes.notes=Notes.getTextArea().getText();
				SettingsIo.SaveNotes();
			}
		}
	}
	
	public static void loggedInHooks() {
		if (Hooks.selector.client.isLoggedIn()) {
			Boot.rsGame.changeName(Hooks.selector.client.getLocalPlayer().getName());
			
			Skill.getProgressedSkills();

			if (StatMonitor.frame!=null) {
				Skill.updateStatMonitor();
			}
		} else {
			Boot.rsGame.changeName(Boot.VERSION);
		}
	}
	
	public static void cycleDumpers() {	
		Dumper.dumpLocalNPCS(c.getLocalNPCs());
	}

	public static void init() {
		t.start();
	}

}
