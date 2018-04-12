package game;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OSRSLauncher {

	public static SystemTray systemTray;
	public static TrayIcon trayIcon;
	static Image icon;

	public static LoaderWindow loaderWindow;

	public static void main(String[] args) {
		try {
			icon = ImageIO.read(new File("./resources/OSJR_tray.png"));
			if (SystemTray.isSupported()) {
				systemTray = SystemTray.getSystemTray();
				try {
					trayIcon = new TrayIcon(icon, "OSJR");
					trayIcon.setImageAutoSize(true);
					systemTray.add(trayIcon);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		loaderWindow = new LoaderWindow(args);
		loaderWindow.setIconImage(icon);
		loaderWindow.setVisible(true);
		loaderWindow.pack();

	}
}
