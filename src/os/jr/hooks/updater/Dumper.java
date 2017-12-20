package os.jr.hooks.updater;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class Dumper {

    public static void saveOSJRHooksDump(HookDump[] hookDump) {
        try {
    		File hooks = new File("./Hooks.txt");
            Writer writer = new FileWriter(hooks);
            writer.write("Hook Revision " + 160 + "\n\n");
            for (HookDump hd : hookDump) {	
            	writer.write("\n{"+hd.rsClass.refactoredName + ": " + hd.rsClass.obfuscatedName+"}" + "\n");
            	for (FieldDump fd : hd.rsFields) {
            		if (fd.multiplier!=null) {
                    	writer.write(fd.refactoredName + ": " + fd.fieldName + ", " + fd.multiplier + "\n");

            		} else {
                    	writer.write(fd.refactoredName + ": " + fd.fieldName + "\n");
            		}
            	}
            }
          //  Gson gson = new GsonBuilder().setPrettyPrinting().create();
           // gson.toJson(hookDump, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
