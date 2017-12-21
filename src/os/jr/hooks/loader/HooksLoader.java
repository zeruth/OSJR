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

	public static void loadHooksJson() {
		Reader reader;

		InputStream inputStream;
		try {
			inputStream = new FileInputStream(hooksFile);
			reader = new InputStreamReader(inputStream, "UTF-8");
			Gson gson = new GsonBuilder().create();
			HookDump[] hooks = gson.fromJson(reader, HookDump[].class);

			for (HookDump hook : hooks) {
				Hooks.classNames.put(hook.rsClass.refactoredName, hook.rsClass.obfuscatedName);

			}
			Hooks.init();
			for (HookDump hook : hooks) {
				for (FieldDump field : hook.rsFields) {
					try {
						GameClass gc = Utils.getClassbyName(field.className);
						if (gc != null)
							gc.fields.put(field.refactoredName, field);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
