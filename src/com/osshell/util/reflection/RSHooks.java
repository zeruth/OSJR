package com.osshell.util.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;

import com.osshell.HookDebugger;
import com.osshell.RsApplet;

public class RSHooks {

	/**
	 * Revision 158
	 */
	public static boolean outdated = false;
	public static boolean scannedForHooks = false;
	public static RSClass client;

	static HashMap<String, String> classHookMap = new HashMap<String, String>();
	static HashMap<String, RSField> fieldHookMap = new HashMap<String, RSField>();

	/**
	 * setHooks - Setup hook definitions. TODO: Implement gson into this method for
	 * easier modifications.
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static void setHooks() throws ClassNotFoundException, NoSuchFieldException, SecurityException {

		/**
		 * Client Hooks
		 */

		classHookMap.put("Client", "client");
		client = loadClass("Client");
		//fieldHookMap.put("Client_Weight", new RSField("Client_Weight", getField(client, "kz"), 911960287));
		//fieldHookMap.put("Client_Energy", new RSField("Client_Energy", getField(client, "kb"), 2121080715));
	//	fieldHookMap.put("Client_CurrentWorld",
			//	new RSField("Client_CurrentWorld", getField(client, "bu"), -1232844837));
		fieldHookMap.put("Client_Experiences", new RSField("Client_Experiences", getField(client, "iv"), 1));
		fieldHookMap.put("Client_RealLevels", new RSField("Client_RealLevels", getField(client, "ie"), 1));
		fieldHookMap.put("Client_CurrentLevels", new RSField("Client_CurrentLevels", getField(client, "if"), 1));

		/*
		 * classHookMap.put("Item", "ch"); classHookMap.put("ItemDefinition", "jx");
		 * classHookMap.put("Widget", "hk"); classHookMap.put("WidgetNode", "bp");
		 * classHookMap.put("Player", "bq"); classHookMap.put("PlayerDefinition", "hd");
		 * classHookMap.put("NPC", "cp"); classHookMap.put("NPCDefinition", "jc");
		 * classHookMap.put("Actor", "bf"); classHookMap.put("CombatInfoHolder", "cy");
		 * classHookMap.put("CombatInfoList", "go"); classHookMap.put("CombatInfo2",
		 * "iz"); classHookMap.put("CombatInfo1", "cn");
		 * classHookMap.put("AnimationSequence", "jf"); Wont use until needed.
		 * classHookMap.put("Model", "en"); classHookMap.put("GrandExchange", "h");
		 * classHookMap.put("SceneTile", "ep"); classHookMap.put("GameObject", "ex");
		 * classHookMap.put("FloorDecoration", "dd"); classHookMap.put("WallDecoration",
		 * "eh"); classHookMap.put("BoundaryObject", "ea");
		 * classHookMap.put("AnimableNode", "cq"); classHookMap.put("Region", "ec");
		 * classHookMap.put("Renderable", "ei"); classHookMap.put("CollisionMap", "fa");
		 * classHookMap.put("BufferedConnection", "ft"); classHookMap.put("Buffer",
		 * "fv"); classHookMap.put("GameShell", "bn"); classHookMap.put("Keyboard",
		 * "ae"); classHookMap.put("ImageRGB", "kd"); classHookMap.put("IndexedRGB",
		 * "ko"); classHookMap.put("TypeFace", "jg"); classHookMap.put("Rasterizer3D",
		 * "eq"); classHookMap.put("Rasterizer", "ky"); classHookMap.put("ClassData",
		 * "kr"); classHookMap.put("Cache", "gr"); classHookMap.put("Queue", "gq");
		 * classHookMap.put("HashTable", "gx"); classHookMap.put("LinkedList", "go");
		 * classHookMap.put("Cacheable", "gu"); classHookMap.put("NodeDeque", "go");
		 * classHookMap.put("Node", "gh");
		 */

	}

	/**
	 * loadClass - Loads a class from the classhookmap then from the JAR.
	 * 
	 * @param string
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static RSClass loadClass(String string) throws ClassNotFoundException {
		String s = classHookMap.get(string);
		if (s=="client") {
		//	return new RSClass(string, s, (Class<?>)RsApplet.clientBootClass);
		}
		return new RSClass(string, s, RsApplet.loader.loadClass(s));
	}

	/**
	 * updateHooks - Fetches current information from all defined hooks.
	 * 
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	public static void updateHooks() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
			SecurityException, ClassNotFoundException {
		if (!outdated) {
			try {
				updateClientHooks();
			} catch (Exception e) {
				System.out.println("Revision out of date!");
				outdated = true;
				return;
			} finally {

			}

		} else {
			if (!scannedForHooks) {
				findHooks();
				scannedForHooks=true;
			}

		}

	}
	
	public static void findHooks() throws SecurityException, ClassNotFoundException {
		findClientExperiences();
	}
	
	public static void findClientExperiences() throws SecurityException, ClassNotFoundException {
		Field[] f = RsApplet.loader.loadClass("client").getDeclaredFields();
		int i = 0;
		while (i<= f.length-1) {
			try {
				f[i].setAccessible(true);
					int[] j = (int[])f[i].get(null);
					if (j.length == 25) {
						System.out.println("Found potential ClientExperiences at client."+f[i].getName());

				}

			} catch (Exception e) {
				//e.printStackTrace();
			}
			i++;
		}
	}

	/**
	 * updateClientHooks - Fetches current information from all client hooks
	 * 
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	public static void updateClientHooks() throws IllegalArgumentException, IllegalAccessException,
			NoSuchFieldException, SecurityException, ClassNotFoundException {
		//getClientWeight();
	//	getClientEnergy();
	//	getClientCurrentWorld();
		getClientExperiences();
		getClientRealLevels();
		getClientCurrentLevels();
	}

	/**
	 * getField - Fetches a field from a given RSClass by unobfuscated name.
	 * 
	 * @param clasz
	 * @param field
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	public static Field getField(RSClass clasz, String field)
			throws NoSuchFieldException, SecurityException, ClassNotFoundException {
		return RsApplet.loader.loadClass(clasz.getObfuscatedName()).getDeclaredField(field);
	}

	/**
	 * fixStaticModInt - Fixes multiplication value, use on any hook with a
	 * multiplier value that isn't 1.
	 * 
	 * @param rsf
	 * @return
	 */
	public static int fixStaticModInt(RSField rsf) {
		return (int) rsf.getValue(null) * rsf.getMultiplier();
	}

	/**
	 * getNonStaticValue - Fetches the Object of a given NON STATIC RSField using
	 * the clientBootClass as a reference.
	 * 
	 * @param f
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getNonStaticValue(RSField f) throws IllegalArgumentException, IllegalAccessException {
		return f.getField().get(RsApplet.clientBootClass);
	}

	/**
	 * getStaticValue - Fetches the Object of a given STATIC field using a null
	 * reference.
	 * 
	 * @param f
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getStaticValue(RSField f) throws IllegalArgumentException, IllegalAccessException {

		return f.getField().get(null);

	}

	/**
	 * Hook Getters
	 */

	public static int[] getClientExperiences() throws IllegalArgumentException, IllegalAccessException,
			NoSuchFieldException, SecurityException, ClassNotFoundException {
		int[] i = (int[]) getStaticValue(fieldHookMap.get("Client_Experiences"));
		HookDebugger.experiences = i;
		return i;
	}

	public static int getClientWeight() {
		int i = fixStaticModInt(fieldHookMap.get("Client_Weight"));
		HookDebugger.weight = i;
		return i;
	}

	public static int getClientEnergy() {
		int i = fixStaticModInt(fieldHookMap.get("Client_Energy"));
		HookDebugger.energy = i;
		return i;
	}

	public static int getClientCurrentWorld() throws IllegalArgumentException, IllegalAccessException {
		int i = (int) fixStaticModInt(fieldHookMap.get("Client_CurrentWorld"));
		HookDebugger.world = i;
		return i;
	}

	public static int[] getClientRealLevels() throws IllegalArgumentException, IllegalAccessException {
		int[] i = (int[]) getStaticValue(fieldHookMap.get("Client_RealLevels"));
		HookDebugger.levels = i;
		return i;
	}

	public static int[] getClientCurrentLevels() throws IllegalArgumentException, IllegalAccessException {
		return (int[]) getStaticValue(fieldHookMap.get("Client_CurrentLevels"));
	}

}
