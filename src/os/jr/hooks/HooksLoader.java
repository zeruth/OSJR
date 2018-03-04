package os.jr.hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import os.jr.hooks.model.RSHook;
import os.jr.hooks.model.RSClass;

public class HooksLoader {

	public static File hooksFile = new File("./Hooks/Hooks.json/");
	private static int totalFields = 0;
	private static int totalClasses = 0;
	private static int totalFieldsAddedToClass = 0;
	public static RSHook[] hooks;

	public static void loadHooksJson() {
		Reader reader;

		InputStream inputStream;
		try {
			inputStream = new FileInputStream(hooksFile);
			reader = new InputStreamReader(inputStream, "UTF-8");
			Gson gson = new GsonBuilder().create();
			hooks = gson.fromJson(reader, RSHook[].class);

			for (RSHook hook : hooks) {
				Hooks.classNames.put(hook.rsClass.refactoredName, hook.rsClass.obfuscatedName);
				Hooks.refactoredClassNames.put(hook.rsClass.obfuscatedName, hook.rsClass.refactoredName);
				totalClasses++;
			}
			Hooks.init();
			for (RSHook hook : hooks) {
				RSClass c = Hooks.getClassbyName(hook.rsClass.refactoredName);
				if (c != null) {
					c.fields = hook.rsFields;
					totalFieldsAddedToClass += hook.rsFields.length;
				}
				totalFields += hook.rsFields.length;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("[OSJR] Loaded " + totalClasses + " Classes.");
		System.out.println("[OSJR] Loaded " + totalFields + " Fields.");
		System.out.println("[OSJR] Loaded " + totalFieldsAddedToClass + " Fields into classes.");
	}
}
