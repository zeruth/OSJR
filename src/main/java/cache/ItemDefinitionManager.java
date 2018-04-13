package cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import hooks.model.ItemDefinition;

public class ItemDefinitionManager {

	public static ItemDefinition[] itemDefinitions;

	@SuppressWarnings("resource")
	public static void init() {
		Gson gson = new Gson();
		try {
			ItemDefinitionManager.itemDefinitions = gson.fromJson(new FileReader(new File("./resources/ItemDef.json")),
					ItemDefinition[].class);
			System.out.println(ItemDefinitionManager.itemDefinitions[100].getName());
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
