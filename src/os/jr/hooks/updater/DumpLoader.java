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
	public static HookDump[] rsClasses;
	
	public static boolean dumpHooksToTxt = false;

	public static void loadFieldDumps () {
		
		FieldDump[] rsFields = new FieldDump[dir.listFiles().length];
		int fieldCount = 0;
		
		for (File f : dir.listFiles()) {
			Reader reader;

				InputStream inputStream;
				try {
					inputStream = new FileInputStream(f);
					reader = new InputStreamReader(inputStream, "UTF-8");
					Gson gson = new GsonBuilder().create();
					FieldDump fieldDump = gson.fromJson(reader, FieldDump.class);
					rsFields[fieldCount] = fieldDump;
					fieldCount++;
					
					GameClass gameClass = Utils.getClassbyName(fieldDump.className);
					if (gameClass!=null) {
						if (fieldDump.multiplier==null) {
							gameClass.fields.put(fieldDump.refactoredName, new GameField(fieldDump.fieldName, gameClass.obfuscatedName));	
						} else {
							gameClass.fields.put(fieldDump.refactoredName, new GameField(fieldDump.fieldName, gameClass.obfuscatedName, fieldDump.multiplier.intValue()));	
						}

						//System.out.println("Added "+fieldDump.className+":"+fieldDump.refactoredName);
						rsFieldCount++;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		if (dumpHooksToTxt)
		Dumper.saveOSJRHooksDump(rsClasses);
		Utils.sendDebugPrintln("Loaded "+rsFieldCount+" RSField compositions. - "+((dir.listFiles().length+1)-rsFieldCount+" RSField compositions not loaded."));
	}
	
	public static FieldDump[] getFields() {
			File dir = new File("./Hooks/Fields/");

			FieldDump[] rsFields = new FieldDump[dir.listFiles().length];
			int fieldCount = 0;
			
			for (File f : dir.listFiles()) {
				Reader reader;

					InputStream inputStream;
					try {
						inputStream = new FileInputStream(f);
						reader = new InputStreamReader(inputStream, "UTF-8");
						Gson gson = new GsonBuilder().create();
						FieldDump fieldDump = gson.fromJson(reader, FieldDump.class);
						rsFields[fieldCount] = fieldDump;
						fieldCount++;
					} catch (Exception e) {
						
					}
			}
		return rsFields;
	}
	

	public static void loadClassDumps() {
		File dir = new File("./Hooks/Classes/");
		rsClasses = new HookDump[dir.listFiles().length];
		int classCount = 0;
		for (File f : dir.listFiles()) {
			InputStream inputStream;
			try {
				inputStream = new FileInputStream(f);
				try (Reader reader = new InputStreamReader(inputStream, "UTF-8")) {
					rsClassCount++;
					Gson gson = new GsonBuilder().create();
					RSClass rsClass = gson.fromJson(reader, RSClass.class);
					if (dumpHooksToTxt) {
						System.out.println(rsClasses[classCount]==null);
						rsClasses[classCount] = new HookDump();
						rsClasses[classCount].rsClass = rsClass;
						int i = 0;
						for (FieldDump fd : getFields()) {
							if (rsClass.refactoredName.compareTo(fd.className)==0) {
								i++;
							}
						}
						rsClasses[classCount].rsFields = new FieldDump[i];
						int j = 0;
						for (FieldDump fd : getFields()) {
							if (rsClass.refactoredName.compareTo(fd.className)==0) {
								rsClasses[classCount].rsFields[j] = fd;
								j++;
							}
						}
					}
					classCount++;
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
		Utils.sendDebugPrintln("Loaded " + rsClasses.length + " RSClass compositions.");
	}

	
}
