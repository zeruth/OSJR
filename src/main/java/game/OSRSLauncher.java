package game;

public class OSRSLauncher {

	public static LoaderWindow loaderWindow;

	public static void main(String[] args) {
		loaderWindow = new LoaderWindow(args);
		for (String s : args) {
			if (s.compareTo("debug") == 0)
				LoaderWindow.game.debug = true;
		}
		loaderWindow.setVisible(true);
		loaderWindow.pack();

	}
}
