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

import os.jr.hooks.Hooks;
import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;
import os.jr.hooks.model.RSClass;
import os.jr.utils.Utils;

public class DumpLoader {
	public static File dir = new File("./Hooks/Fields/");
	public static int rsFieldCount = 0;
	public static int rsClassCount = 0;

	public static void loadFieldDumps () {
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
						if (fieldDump.multiplier.intValue()==1) {
							gameClass.fields.put(fieldDump.refactoredName, new GameField(fieldDump.fieldName, gameClass.obfuscatedName));	
						} else {
							gameClass.fields.put(fieldDump.refactoredName, new GameField(fieldDump.fieldName, gameClass.obfuscatedName, fieldDump.multiplier.intValue()));	
						}

						//System.out.println("Added "+fieldDump.className+":"+fieldDump.refactoredName);
						rsFieldCount++;
					}
				} catch (Exception e) {
					//e.printStackTrace();
				}
		}
		Utils.sendDebugPrintln("Loaded "+rsFieldCount+" RSField compositions. - "+((dir.listFiles().length+1)-rsFieldCount+" RSField compositions not loaded."));
	}
	

	public static void loadClassDumps() {
		File dir = new File("./Hooks/Classes/");
		for (File f : dir.listFiles()) {
			InputStream inputStream;
			try {
				inputStream = new FileInputStream(f);
				try (Reader reader = new InputStreamReader(inputStream, "UTF-8")) {
					rsClassCount++;
					Gson gson = new GsonBuilder().create();
					RSClass rsClass = gson.fromJson(reader, RSClass.class);
					Hooks.classNames.put(rsClass.refactoredName, rsClass.obfuscatedName);
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

		}
		Utils.sendDebugPrintln("Loaded " + rsClassCount + " RSClass compositions.");
	}

	
}
