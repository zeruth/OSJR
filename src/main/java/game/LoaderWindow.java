package game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ToolTipManager;

import paint.MenuHandler;

public class LoaderWindow extends JFrame {

	public static Game game;
	private static final long serialVersionUID = 1L;
	private JPanel gamePanel;
	private MenuHandler menuHandler;
	private Container contentPanel;

	public LoaderWindow(String[] args) {
		boolean vanilla = false;
		for (String s : args) {
			if (s.compareTo("vanilla") == 0) {
				vanilla = true;
			}
		}
		if (vanilla) {
			game = new Game(args);
		} else {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(true);
			setSize(780, 563);
			setTitle("OSJR");
			setLayout(new BorderLayout());

			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);

			this.contentPanel = getContentPane();
			this.contentPanel.setLayout(new BorderLayout());
			this.gamePanel = new JPanel();
			this.contentPanel.add(this.gamePanel);

			try {
				this.contentPanel.repaint();
				this.contentPanel.revalidate();
				game = new Game(args);
				this.contentPanel.add(game);
				this.contentPanel.setVisible(true);
				this.contentPanel.setSize(765, 503);
				this.contentPanel.repaint();
				this.contentPanel.revalidate();
				setResizable(true);
			} catch (Exception e) {
			}

			this.menuHandler = new MenuHandler(this, game);
			this.setJMenuBar(this.menuHandler.makeJMenuBar());

		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

}