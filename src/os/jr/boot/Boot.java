package os.jr.boot;

import java.io.IOException;
import javax.swing.JFrame;

import os.jr.game.GameFrame;
import os.jr.game.Reflector;
import os.jr.game.Updater;
import os.jr.hooks.Client;
import os.jr.hooks.Hooks;
import os.jr.hooks.updater.HookUpdater;
import os.jr.utils.SettingsIo;

public class Boot extends JFrame {

	public static Object rootReference;

	public static boolean outdated = false;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException, NoSuchFieldException, ClassNotFoundException {

		if (!SettingsIo.dir.exists()) {
			SettingsIo.dir.mkdir();
		}
		if (!SettingsIo.file.exists()) {
			SettingsIo.createBlankDb();
		}
		Client.settings = SettingsIo.loadSettings();

		Updater.main();
		new Reflector();
		new GameFrame();
		Hooks.init();
		HookUpdater.init();
		Test.main();

	}

}
