package os.jr.hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import os.jr.hooks.model.RSClass;

public class HooksLoader {

	public static File hooksFile = new File("./Hooks/Hooks.json/");
	private static int totalFields = 0;
	private static int totalClasses = 0;
	private static int totalFieldsAddedToClass = 0;
	public static RSClass[] hooks;

	public static void loadHooksJson() {
		Reader reader;

		InputStream inputStream;
		try {
			inputStream = new FileInputStream(hooksFile);
			reader = new InputStreamReader(inputStream, "UTF-8");
			Gson gson = new GsonBuilder().create();
			hooks = gson.fromJson(reader, RSClass[].class);

			for (RSClass hook : hooks) {
				if (hook!=null) {
					Hooks.classNames.put(hook.name, hook.obfuscatedName);
					Hooks.refactoredClassNames.put(hook.obfuscatedName, hook.name);
					totalClasses++;	
				}
			}
			Hooks.init();
			for (RSClass hook : hooks) {
				if (hook!=null) {
					RSClass c = Hooks.getClassbyName(hook.name);
					if (c != null) {
						c.fields = hook.fields;
						totalFieldsAddedToClass += hook.fields.length;
					}
					totalFields += hook.fields.length;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("[OSJR] Loaded " + totalClasses + " Classes.");
		System.out.println("[OSJR] Loaded " + totalFields + " Fields.");
		System.out.println("[OSJR] Loaded " + totalFieldsAddedToClass + " Fields into classes.");
	}
}
