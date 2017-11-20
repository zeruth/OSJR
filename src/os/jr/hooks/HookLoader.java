package os.jr.hooks;

import java.util.Hashtable;

import os.jr.game.accessors.Client;
import os.jr.hooks.model.RSClass;
import os.jr.hooks.model.RSField;
import os.jr.loader.Loader;

public class HookLoader {
	
	public static Hashtable<String, RSClass> classStorage = new Hashtable<String, RSClass>();
	
	public static String player;
	
	public static RSClass client;
	public static RSField Client_LocalPlayer;
						
							
							
	
	public static void loadHooks() {
		ClassLoader cl = Loader.classLoader;
		try {

			client = new RSClass("Client", "client", cl.loadClass("client"));
			Class<?> c = cl.loadClass(client.getObfuscatedName());
			classStorage.put("Client", client);
			
			classStorage.get("Client").putField("Client_LocalPlayer", cl.loadClass("jv"), "iq", 1);
			classStorage.get("Client").putField("Client_Experiences", null, "iv", 1);
			classStorage.get("Client").putField("Client_RealLevels", null, "if", 1);
			classStorage.get("Client").putField("Client_CurrentLevels", null, "ie", 1);
			classStorage.get("Client").putField("Client_Energy", null, "kg", 495608037);
			classStorage.get("Client").putField("Client_Weight", null, "ku", 684307151);
			classStorage.get("Client").putField("Client_CurrentWorld", null, "ba", -594959723);
			classStorage.get("Client").putField("Client_LocalPlayers", null, "hn", 1);
			classStorage.get("Client").putField("Client_LoginState", null, "bh", -128959435);
			classStorage.get("Client").putField("Client_GameState", cl.loadClass("ca"), "as", -1269510535);
			
			player = "bd";
			c = cl.loadClass(player);
			classStorage.put("Player", new RSClass("Player", player, c));
			classStorage.get("Player").putField("Player_Name", null, "b", 1);
			classStorage.get("Player").putField("Player_Model", null, "j", 1);
			classStorage.get("Player").putField("Player_Visible", null, "p", 1);
			classStorage.get("Player").putField("Player_CombatLevel", null, "u", 811274801);



			Client.client = client;

		} catch (ClassNotFoundException e) {
			System.out.println("Client Outdated!");
			e.printStackTrace();
		}
	}

}
