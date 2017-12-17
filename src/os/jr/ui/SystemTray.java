package os.jr.ui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;

import javax.imageio.ImageIO;

import os.jr.boot.Boot;
import os.jr.game.RSGame;

public class SystemTray {
	
	public static java.awt.SystemTray setupSystemTray() {
		if (java.awt.SystemTray.isSupported()) {
	        //Obtain only one instance of the SystemTray object
			java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();

	        //If the icon is a file
	        Image image;
			try {
				image = ImageIO.read(SystemTray.class.getResource("/resources/OSJR-Icon.png"));
		        TrayIcon trayIcon = new TrayIcon(image, "OS-JR");
		        trayIcon.setImageAutoSize(true);
		        trayIcon.setToolTip("OS-JR version " + Boot.VERSION);
				tray.add(trayIcon);
			} catch (IOException | AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        return tray;
		} else {
			System.out.println("System Tray functions not supported.");
		}
		return null;
	}
	
	public static void sendMessageNormal(String text) {
		RSGame.systemTray.getTrayIcons()[0].displayMessage("OS-JR", text, MessageType.NONE);
	}
	public static void sendMessageInfo(String text) {
		RSGame.systemTray.getTrayIcons()[0].displayMessage("OS-JR", text, MessageType.INFO);
	}
	public static void sendMessageWarning(String text) {
		RSGame.systemTray.getTrayIcons()[0].displayMessage("OS-JR", text, MessageType.WARNING);
	}
	public static void sendMessageError(String text) {
		RSGame.systemTray.getTrayIcons()[0].displayMessage("OS-JR", text, MessageType.ERROR);
	}

}
