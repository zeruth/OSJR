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

					GameClass gameClass = getClassbyName(fieldDump.className);
					if (gameClass!=null) {
						gameClass.fields.put(fieldDump.refactoredName, new GameField(fieldDump.fieldName, gameClass.className));
						System.out.println("Added "+fieldDump.className+":"+fieldDump.refactoredName);
						Hooks.hookCount++;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	
	public static GameClass getClassbyName(String name) {
		if (name.compareTo("AbstractByteBuffer")==0) {
			return Hooks.selector.abstractByteBuffer;
		} else if (name.compareTo("AbstractIntegerNode0")==0) {
			return Hooks.selector.abstractIntegerNode0;
		} else if (name.compareTo("AbstractSoundSystem")==0) {
			return Hooks.selector.abstractSoundSystem;
		} else if (name.compareTo("Actor")==0) {
			return Hooks.selector.actor;
		} else if (name.compareTo("Area")==0) {
			return Hooks.selector.area;
		} else if (name.compareTo("AttackOption")==0) {
			return Hooks.selector.attackOption;
		} else if (name.compareTo("AudioEnvelope")==0) {
			return Hooks.selector.audioEnvelope;
		} else if (name.compareTo("AudioInstrument")==0) {
			return Hooks.selector.audioInstrument;
		}

		return null;
	}
}
