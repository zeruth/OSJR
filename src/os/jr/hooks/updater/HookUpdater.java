package os.jr.hooks.updater;

import os.jr.boot.Boot;
import os.jr.ui.Notes;
import os.jr.utils.SettingsIo;
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
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	});
	
	public static void anyStateHooks() {

		if (Notes.frame!=null) {
			if (Notes.getTextArea().getText().compareTo(Notes.notes)!=0) {
				Notes.notes=Notes.getTextArea().getText();
				SettingsIo.SaveNotes();
			}
		}
	}
	
	public static void loggedInHooks() {

	}
	

	public static void init() {
		t.start();
	}

}
