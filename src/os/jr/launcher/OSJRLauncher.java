package os.jr.launcher;

import javax.swing.JFrame;

import os.jr.game.RSGame;

public class OSJRLauncher {

	public static JFrame rsFrame = new JFrame();
	public static RSGame rsGame = new RSGame();

	public static void main(String[] args) {

		OSJRLauncher b = new OSJRLauncher();
		rsGame.run();
		b.addApplet();

	}

	public OSJRLauncher() {
		rsFrame.setSize(781, 542);
		rsFrame.setTitle("OS-JR Standalone Launcher");
		rsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addApplet() {
		rsFrame.add(RSGame.applet);
		rsFrame.validate();
		rsFrame.setVisible(true);
	}
	
	public static void updateTitle(String title) {
		rsFrame.setTitle(title);
	}

}
