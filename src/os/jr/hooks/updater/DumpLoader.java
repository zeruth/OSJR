package os.jr.hooks.updater;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import os.jr.hooks.Actor;
import os.jr.hooks.Hooks;
import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;
import os.jr.utils.Settings;
import os.jr.utils.Utils;

public class DumpLoader {
	public static File dir = new File(System.getProperty("user.home") + "/OSJR/Hooks/");

	public static void loadHookDumps () {
		for (File f : dir.listFiles()) {
			Reader reader;

				InputStream inputStream;
				try {
					inputStream = new FileInputStream(f);
					reader = new InputStreamReader(inputStream, "UTF-8");
					Gson gson = new GsonBuilder().create();
					FieldDump fieldDump = gson.fromJson(reader, FieldDump.class);

					GameClass gameClass = Utils.getClassbyName(fieldDump.className);
					if (gameClass!=null) {
						gameClass.fields.put(fieldDump.refactoredName, new GameField(fieldDump.fieldName, gameClass.obfuscatedName));
						System.out.println("Added "+fieldDump.className+":"+fieldDump.refactoredName);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		System.out.println("Loaded "+Hooks.hookCount+" Hooks.");
		System.out.println((dir.listFiles().length+1)-Hooks.hookCount+" Not Loaded.");
	}
	
}
