package os.jr.hooks.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import os.jr.hooks.Hooks;
import os.jr.utils.Utils;

public class HooksLoader {

	public static File hooksFile = new File("./Hooks/Hooks.json/");
	private static int totalFields = 0;
	private static int totalClasses = 0;
	private static int totalFieldsAddedToClass = 0;
	public static HookDump[] hooks;

	public static void loadHooksJson() {
		Reader reader;

		InputStream inputStream;
		try {
			inputStream = new FileInputStream(hooksFile);
			reader = new InputStreamReader(inputStream, "UTF-8");
			Gson gson = new GsonBuilder().create();
			hooks = gson.fromJson(reader, HookDump[].class);

			for (HookDump hook : hooks) {
				Hooks.classNames.put(hook.rsClass.refactoredName, hook.rsClass.obfuscatedName);
				Hooks.refactoredClassNames.put(hook.rsClass.obfuscatedName, hook.rsClass.refactoredName);
				totalClasses ++;
			}
			Hooks.init();
			for (HookDump hook : hooks) {
				RSClass c = Utils.getClassbyName(hook.rsClass.refactoredName);
				if (c!=null) {
					c.fields = hook.rsFields;
					totalFieldsAddedToClass+=hook.rsFields.length+1;
				}
				totalFields+=hook.rsFields.length+1;

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("[OSJR] Loaded "+totalClasses+" Classes.");
		System.out.println("[OSJR] Loaded "+totalFields+" Fields.");
		System.out.println("[OSJR] Loaded "+totalFieldsAddedToClass+" Fields into classes.");
	}
}
