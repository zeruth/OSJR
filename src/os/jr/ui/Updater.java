package os.jr.ui;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import os.jr.game.RSGame;
import os.jr.utils.Utils;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class Updater extends JFrame {

	/**
	 * 
	 */
	public static Updater window;
	public static boolean downloadComplete;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JProgressBar progressBar;
	public static int progress = 0;

	/**
	 * Create the frame.
	 */
	public Updater() {
		setTitle("Update Required");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 119);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 11, 349, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUpdatingGamepack = new JLabel("Updating Gamepack");
		lblUpdatingGamepack.setForeground(Color.WHITE);
		lblUpdatingGamepack.setBounds(125, 11, 193, 14);
		panel.add(lblUpdatingGamepack);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.BLACK);
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBounds(10, 36, 329, 14);
		panel.add(progressBar);
	}
	
	public static JProgressBar getProgressBar() {
		return progressBar;
	}
	
	public static boolean downloadRequired = false;

	public static Thread download = new Thread(new Runnable() {

		@Override
		public void run() {

			try {
				Utils.downloadGamePack();
				downloadRequired=false;
				downloadComplete=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	});
	public static int maximum = 0;
	
	public static void checkUpdate() {
		if (RSGame.settings.gamePackSize == -1
				|| RSGame.settings.gamePackSize != Utils.getFileSize(RSGame.LIVE_JAR_URL)
				|| Utils.localGamePackSize() != Utils.getFileSize(RSGame.LIVE_JAR_URL)) {
			downloadRequired = true;
		}
		if (downloadRequired) {
			download.start();
			try {
				window = new Updater();
				window.setVisible(true);
				progressBar.setMaximum(Utils.getFileSize(RSGame.LIVE_JAR_URL));
				while (!downloadComplete) {
					setSelection(progress);
					progressBar.repaint();
					Thread.sleep(200);
				}
				window.dispose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setSelection(int selection) {
		progressBar.setValue(selection);
	}
}
