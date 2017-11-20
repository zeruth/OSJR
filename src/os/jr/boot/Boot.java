package os.jr.boot;

import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;

import os.jr.game.accessors.Client;
import os.jr.hooks.HookLoader;
import os.jr.hooks.HookUpdater;
import os.jr.loader.GameFrame;
import os.jr.loader.Loader;
import os.jr.loader.Updater;
import os.jr.utils.SettingsIo;

public class Boot extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException, NoSuchFieldException {
		
		if (!SettingsIo.dir.exists()) {
			SettingsIo.dir.mkdir();
		}
		if (!SettingsIo.file.exists()) {
			SettingsIo.createBlankDb();
		}
		Client.settings = SettingsIo.loadSettings();

		Updater.main();
		new Loader();
		new GameFrame();
		HookLoader.loadHooks();
		HookUpdater.init();
		Test.main();

	}

}
