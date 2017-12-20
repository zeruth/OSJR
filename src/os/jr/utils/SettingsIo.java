package os.jr.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class SettingsIo {
	public static Settings settings = new Settings();
	public static File file = new File(System.getProperty("user.home") + "/OSJR/settings");
	public static File dir = new File(System.getProperty("user.home") + "/OSJR/");

	/**
	 * loadSettings - Loads settings from user data directory using Gson.
	 * 
	 * @return = Returns settings file in data directory as an object.
	 * @throws UnsupportedEncodingException
	 *             = Malformed settings file.
	 * @throws IOException
	 *             = Various I/O related issues.
	 */
	public static Settings loadSettings() {
		InputStream inputStream;
		try {
			if (!file.exists())
				createBlankDb();
			inputStream = new FileInputStream(file);
			try (Reader reader = new InputStreamReader(inputStream, "UTF-8")) {
				Gson gson = new GsonBuilder().create();
				Settings settings = gson.fromJson(reader, Settings.class);
				return settings;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * createBlankDB - Creates blank settings file in user data directory.
	 * 
	 * @throws IOException
	 *             = Various I/O issues.
	 */
	public static void createBlankDb() {
		Writer writer;
		try {
			Settings s = new Settings();
			writer = new FileWriter(file);
			Gson gson = new GsonBuilder().create();
			gson.toJson(s, writer);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * updateGamePackSize - Overwrites the old gamepack size in settings file.
	 * 
	 * @param size
	 *            = Size of new gamepack.
	 * @throws UnsupportedEncodingException
	 *             = Malformed settings file.
	 * @throws IOException
	 *             = Various I/O issues.
	 */
	public static void updateGamePackSize(int size) {
		Settings s = loadSettings();
		s.gamePackSize = size;
		saveSettings(s);
	}

	/**
	 * saveSettings - Saves Settings object to file in data directory.
	 * 
	 * @param s
	 *            = Settings object to be saved.
	 * @throws IOException
	 *             = Various I/O issues.
	 */
	public static void saveSettings(Settings s){
		try {
			Writer writer = new FileWriter(file);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(s, writer);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}