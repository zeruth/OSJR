package os.jr.boot;

import javax.swing.JFrame;

import os.jr.game.RSGame;
import os.jr.hooks.Client;
import os.jr.ui.StatMonitor;
import os.jr.ui.Notes;
import os.jr.utils.SettingsIo;

public class Boot extends JFrame {

	private static final long serialVersionUID = 1L;
	public static Object rootReference;
	public static RSGame rsGame = new RSGame();
	public static boolean outdated = false;
	public static final String VERSION = "0.5.7";
	public static final int HOOK_REVISION = 160;

	public static void main(String[] args) {

		initSettings();
		rsGame.run();
		StatMonitor.init();
		Notes.init();

	}
	
	public static void initSettings() {

		if (!SettingsIo.dir.exists()) {
			SettingsIo.dir.mkdir();
		}
		if (!SettingsIo.file.exists()) {
			SettingsIo.createBlankDb();
		}
		
		Client.settings = SettingsIo.loadSettings();
	}

}
