package os.jr.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class SettingsIo {
	public static Settings settings = new Settings();
	public static File file = new File(System.getProperty("user.home") + "/OSJR/settings.txt");
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
	public static Settings loadSettings() throws UnsupportedEncodingException, IOException {
		InputStream inputStream = new FileInputStream(file);
		try (Reader reader = new InputStreamReader(inputStream, "UTF-8")) {
			Gson gson = new GsonBuilder().create();
			Settings settings = gson.fromJson(reader, Settings.class);
			return settings;
		}
	}

	/**
	 * createBlankDB - Creates blank settings file in user data directory.
	 * 
	 * @throws IOException
	 *             = Various I/O issues.
	 */
	public static void createBlankDb() throws IOException {
		Settings s = new Settings();
		Writer writer = new FileWriter(file);
		Gson gson = new GsonBuilder().create();
		gson.toJson(s, writer);
		writer.close();
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
	public static void updateGamePackSize(int size) throws UnsupportedEncodingException, IOException {
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
	public static void saveSettings(Settings s) throws IOException {
		Writer writer = new FileWriter(file);
		Gson gson = new GsonBuilder().create();
		gson.toJson(s, writer);
		writer.close();
	}
}