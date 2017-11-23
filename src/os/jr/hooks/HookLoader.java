package os.jr.hooks;

import java.util.Hashtable;

import os.jr.boot.Boot;
import os.jr.game.Reflector;
import os.jr.game.accessors.Client;
import os.jr.hooks.model.RSClass;
import os.jr.hooks.model.RSField;

public class HookLoader {
	
	public static Hashtable<String, RSClass> classStorage = new Hashtable<String, RSClass>();
	
	public static String player, imageRGB, combatInfoList, actor;
	
	public static RSClass client;
	public static RSField Client_LocalPlayer;
						
							
							
	
	public static void loadHooks() {
		ClassLoader cl = Reflector.classLoader;
		try {

			client = new RSClass("Client", "client", cl.loadClass("client"));
			Class<?> c = cl.loadClass(client.getObfuscatedName());
			classStorage.put("Client", client);
			
			if (!Boot.outdated) {
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
				
				imageRGB = "kb";
				c = cl.loadClass(imageRGB);
				classStorage.put("ImageRGB", new RSClass("ImageRGB", imageRGB, c));
				classStorage.get("ImageRGB").putField("ImageRGB_Pixels", null, "s", 1);
				
				combatInfoList = "gx";
				c = cl.loadClass(combatInfoList);
				classStorage.put("CombatInfoList", new RSClass("CombatInfoList", combatInfoList, c));
				classStorage.get("CombatInfoList").putField("CombatInfoList_Head", null, "b", 1);
				classStorage.get("CombatInfoList").putField("CombatInfoList_Current", null, "s", 1);
				
				actor = "bw";
				c = cl.loadClass(actor);
				classStorage.put("Actor", new RSClass("Actor", actor, c));
				classStorage.get("Actor").putField("Actor_CombatInfoList", null, "bi", 1);	
			}
			Client.client = client;

		} catch (Exception e) {

		}
	}

}
