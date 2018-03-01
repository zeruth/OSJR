package os.jr.game;

import java.applet.Applet;
import java.awt.Canvas;

import javax.swing.JFrame;

public class OSJRLauncher extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		Applet applet = RSGame.applet;
			applet.setStub(rsGame);
			applet.setSize(766, 503);
			applet.init();
			applet.start();
		rsFrame.add(RSGame.applet);
		rsFrame.validate();
		rsFrame.setVisible(true);
	}
	
	public static void updateTitle(String title) {
		rsFrame.setTitle(title);
	}

}
