package os.jr.game;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import os.jr.hooks.Client;
import os.jr.utils.Utils;

import org.eclipse.swt.widgets.ProgressBar;

import java.io.IOException;

import org.eclipse.swt.SWT;

public class Updater {

	public static ProgressBar progressBar;
	protected Shell shell;
	public static int progress = 0;
	public static int maximum = 0;
	public static boolean downloadComplete;
	public static boolean downloadRequired = false;

	public static Thread download = new Thread(new Runnable() {

		@Override
		public void run() {

			try {
				Utils.downloadGamePack();
				downloadComplete = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	});

	/**
	 * Launch the application.
	 * 
	 * @param args
	 * @throws IOException
	 * @wbp.parser.entryPoint
	 */
	public static void main() {
		if (Client.settings.gamePackSize == -1
				|| Client.settings.gamePackSize != Utils.getFileSize(RSGame.LIVE_JAR_URL)
				|| Utils.localGamePackSize() != Utils.getFileSize(RSGame.LIVE_JAR_URL)) {
			downloadRequired = true;
		}
		if (downloadRequired) {
			download.start();
			try {
				Updater window = new Updater();
				window.open();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Open the window.
	 * 
	 * @throws IOException
	 */
	public void open() throws IOException {

		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		progressBar.setMaximum(Utils.getFileSize(RSGame.LIVE_JAR_URL));
		while (!shell.isDisposed() && !downloadComplete) {
			setSelection(progress);
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		shell.dispose();
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 73);
		shell.setText("Downloading updated gamepack");

		progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setBounds(10, 10, 414, 17);

	}

	public static void setSelection(int selection) {
		progressBar.setSelection(selection);
	}
}
