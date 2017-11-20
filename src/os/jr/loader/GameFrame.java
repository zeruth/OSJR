package os.jr.loader;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static JFrame gameFrame = new JFrame();

	public GameFrame() {
		gameFrame.setTitle("OS-JR");
		gameFrame.setSize(781, 543);
		gameFrame.setResizable(true);
		gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gameFrame.add(Loader.applet);
		gameFrame.setVisible(true);
	}
	
	public static void changeName(String name) {
		gameFrame.setTitle("OS-JR ["+name+"]");
	}

}
