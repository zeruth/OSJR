package os.jr.boot;

import javax.swing.JFrame;

import os.jr.game.RSGame;

public class Boot extends JFrame {
	
	public Boot() {
		setVisible(true);
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private static final long serialVersionUID = 1L;
	public static RSGame rsGame = new RSGame();

	public static void main(String[] args) {

		Boot b = new Boot();
		Boot.rsGame.run();
		b.addApplet();

	}
	
	private void addApplet() {
		add(RSGame.applet);
		validate();
	}

}
