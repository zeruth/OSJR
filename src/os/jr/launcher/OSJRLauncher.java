package os.jr.launcher;

import javax.swing.JFrame;

import os.jr.game.RSGame;

public class OSJRLauncher extends JFrame {

	private static final long serialVersionUID = 1L;

	public static RSGame rsGame = new RSGame();

	public static void main(String[] args) {

		OSJRLauncher b = new OSJRLauncher();
		OSJRLauncher.rsGame.run();
		b.addApplet();

	}

	public OSJRLauncher() {
		setSize(781, 542);
		setTitle("OS-JR Standalone Launcher");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void addApplet() {
		add(RSGame.applet);
		validate();
		setVisible(true);
	}

}
