package os.jr.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DumperIo {
	public static Settings settings = new Settings();
	public static File dir = new File(System.getProperty("user.home") + "/OSJR/Dumps/");

	public static void writeDumpedObject(String name, Object object) {
		if (!dir.exists()) {
			dir.mkdir();
		}
		Writer writer;
		try {
			writer = new FileWriter(dir+"/"+name+".txt");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(object, writer);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}