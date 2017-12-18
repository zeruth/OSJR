package os.jr.hooks.updater;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import os.jr.hooks.Hooks;
import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;
import os.jr.utils.Utils;

public class DumpLoader {
	public static File dir = new File("./Dumps/Fields/");

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

					//	System.out.println("Added "+fieldDump.className+":"+fieldDump.refactoredName);
						Hooks.rsFieldCount++;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		System.out.println();
		System.out.println("Loaded " + Hooks.rsClassCount + " RSClass compositions.");
		System.out.println("Loaded "+Hooks.rsFieldCount+" RSField compositions. - "+((dir.listFiles().length+1)-Hooks.rsFieldCount+" RSField compositions not loaded."));
	}
	
}
