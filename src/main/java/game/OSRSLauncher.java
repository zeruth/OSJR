package game;

public class OSRSLauncher {

	public static LoaderWindow loaderWindow;

	public static void main(String[] args) {
		loaderWindow = new LoaderWindow(args);
		loaderWindow.setVisible(true);
		loaderWindow.pack();

	}
}
