package os.rs.game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ToolTipManager;

import os.rs.paint.Console;
import os.rs.paint.MenuHandler;

public class LoaderWindow extends JFrame {

	public static Game game;
	private static final long serialVersionUID = 1L;
	private Console console;
	private JPanel gamePanel;
	private MenuHandler menuHandler;

	public LoaderWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setSize(780, 563);
		setTitle("OSJR");
		setLayout(new BorderLayout());

		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);

		Container contentPanel = getContentPane();
		contentPanel.setLayout(new BorderLayout());
		gamePanel = new JPanel();
		contentPanel.add(gamePanel);

		try {
			contentPanel.repaint();
			contentPanel.revalidate();
			game = new Game();
			contentPanel.add(game);
			contentPanel.setVisible(true);
			contentPanel.setSize(765, 503);
			contentPanel.repaint();
			contentPanel.revalidate();
			setResizable(true);
		} catch (Exception e) {
		}

		console = new Console(game);

		menuHandler = new MenuHandler(this, game, console);
		this.setJMenuBar(menuHandler.makeJMenuBar());

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// gamePanel.setSize(Boot.loaderWindow.getSize());
	}

}