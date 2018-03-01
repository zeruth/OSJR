package os.jr.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import os.jr.game.RSGame;
import os.jr.game.Updater;

public class Utils {

	public static int size;

	public static void downloadGamePack() throws UnsupportedEncodingException, IOException {
		BufferedInputStream in = null;
		FileOutputStream out = null;
		try {
			URL url = RSGame.LIVE_JAR_URL;
			URLConnection conn = url.openConnection();
			size = conn.getContentLength();
			Updater.maximum = size;
			if (size < 0) {
				System.out.println("Could not get the file size");
			} else {
				System.out.println("\nGamepack update required.");
			}
			File file = new File(System.getProperty("user.home") + "/OSJR/");
			File file2 = new File(System.getProperty("user.home") + "/OSJR/gamepack.jar");
			file.mkdir();
			file2.createNewFile();
			in = new BufferedInputStream(url.openStream());
			out = new FileOutputStream(file2);
			byte[] data = new byte[1024];
			int count;
			double sumCount = 0.0;
			while ((count = in.read(data, 0, 1024)) != -1) {
				out.write(data, 0, count);
				sumCount += count;
				if (size > 0) {
					Updater.progress = (int) (sumCount);
				}
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e3) {
					e3.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e4) {
					e4.printStackTrace();
				}
			}
			SettingsIo.updateGamePackSize(size);
			Updater.downloadComplete = true;
		}
	}

	public static int getFileSize(URL url) {
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("HEAD");
			conn.getInputStream();
			return conn.getContentLength();
		} catch (IOException e) {
			return -1;
		} finally {
			conn.disconnect();
		}
	}

	public static String getParamName(String param) {
		try {
			int startIndex = param.indexOf("<param name=\"") + 13;
			int endIndex = param.indexOf("\" value");
			return param.substring(startIndex, endIndex);
		} catch (StringIndexOutOfBoundsException e) {
			int startIndex = param.indexOf("<param name=") + 12;
			int endIndex = param.indexOf(" value");
			return param.substring(startIndex, endIndex);
		}
	}

	public static String getParamValue(String param) {
		try {
			int startIndex = param.indexOf("value=\"") + 7;
			int endIndex = param.indexOf("\">');");
			return param.substring(startIndex, endIndex);
		} catch (StringIndexOutOfBoundsException e) {
			int startIndex = param.indexOf("value=") + 6;
			int endIndex = param.indexOf(">');");
			return param.substring(startIndex, endIndex);
		}
	}

	public static String getUTCTime() {
		LocalDateTime ldt1 = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
		String second = "" + ldt1.getSecond();
		String minute = "" + ldt1.getMinute();
		String hour = "" + ldt1.getHour();

		if (Integer.valueOf(second) < 10) {
			second = "0" + second;
		}
		if (Integer.valueOf(minute) < 10) {
			minute = "0" + minute;
		}
		if (Integer.valueOf(hour) < 10) {
			hour = "0" + hour;
		}
		return hour + ":" + minute + ":" + second + " UTC";
	}

	public static int localGamePackSize() {
		File file = new File(System.getProperty("user.home") + "/OSJR/gamepack.jar");
		return (int) file.length();
	}

	public static void sendDebugPrintln(String text) {
		System.out.println("[OSJR] " + text);
	}

}
