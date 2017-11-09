package com.osshell.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SettingsIO {

	public static Settings settings = new Settings();
	public static File file = new File(System.getProperty("user.home") + "/OSLite/settings.txt");

	public static Settings loadSettings() throws UnsupportedEncodingException, IOException {
		InputStream inputStream = new FileInputStream(file);
		try (Reader reader = new InputStreamReader(inputStream, "UTF-8")) {
			Gson gson = new GsonBuilder().create();
			Settings settings = gson.fromJson(reader, Settings.class);
			return settings;
		}

	}

	public static void createBlankDB() throws IOException {
		Settings s = new Settings();
		Writer writer = new FileWriter(file);
		Gson gson = new GsonBuilder().create();
		gson.toJson(s, writer);
		writer.close();
		System.out.println("Created Settings file.");
	}
	
	public static void updateGamePackSize(int size) throws UnsupportedEncodingException, IOException {
		Settings s = loadSettings();
		s.gamePackSize=size;
		saveSettings(s);
		System.out.println("GamePackSize updated to "+size);
	}
	
	public static void saveSettings(Settings s) throws IOException {
		Writer writer = new FileWriter(file);
    	Gson gson = new GsonBuilder().create();
    	gson.toJson(s, writer);
    	writer.close();
	}

}
