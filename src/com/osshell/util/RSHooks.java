package com.osshell.util;

import java.lang.reflect.Field;
import java.util.HashMap;

import com.osshell.HookDebugger;
import com.osshell.RsApplet;

public class RSHooks {
	
	/**
	 * Revision 157
	 * @throws ClassNotFoundException 
	 */
	public static RSClass client;
	
	public static RSField client_experiences,
							client_weight,
							client_energy;
	
	public static RSClass player;
	
	static HashMap<String,String> classHookMap = new HashMap<String,String>();
	static HashMap<String,RSField> fieldHookMap = new HashMap<String,RSField>();
	
public static void setHooks() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
	
	classHookMap.put("Client", "client");
	client = loadClass("Client");
	fieldHookMap.put("Client_Weight", new RSField("Client_Weight", getField(client, "kz"), 911960287));
	fieldHookMap.put("Client_Energy", new RSField("Client_Energy", getField(client, "kb"), 2121080715));
	fieldHookMap.put("Client_CurrentWorld", new RSField("Client_CurrentWorld", getField(client, "bu"), -1232844837));
	fieldHookMap.put("Client_Experiences", new RSField("Client_Experiences", getField(client, "il"), 1));
	fieldHookMap.put("Client_RealLevels", new RSField("Client_RealLevels", getField(client, "ir"), 1));
	fieldHookMap.put("Client_CurrentLevels", new RSField("Client_CurrentLevels", getField(client, "ir"), 1));
	
	/*
	classHookMap.put("Item", "ch");
	classHookMap.put("ItemDefinition", "jx");
	classHookMap.put("Widget", "hk");
	classHookMap.put("WidgetNode", "bp");
	classHookMap.put("Player", "bq");
	classHookMap.put("PlayerDefinition", "hd");
	classHookMap.put("NPC", "cp");
	classHookMap.put("NPCDefinition", "jc");
	classHookMap.put("Actor", "bf");
	classHookMap.put("CombatInfoHolder", "cy");
	classHookMap.put("CombatInfoList", "go");
	classHookMap.put("CombatInfo2", "iz");
	classHookMap.put("CombatInfo1", "cn");
	classHookMap.put("AnimationSequence", "jf");   Wont use until needed.
	classHookMap.put("Model", "en");
	classHookMap.put("GrandExchange", "h");
	classHookMap.put("SceneTile", "ep");
	classHookMap.put("GameObject", "ex");
	classHookMap.put("FloorDecoration", "dd");
	classHookMap.put("WallDecoration", "eh");
	classHookMap.put("BoundaryObject", "ea");
	classHookMap.put("AnimableNode", "cq");
	classHookMap.put("Region", "ec");
	classHookMap.put("Renderable", "ei");
	classHookMap.put("CollisionMap", "fa");
	classHookMap.put("BufferedConnection", "ft");
	classHookMap.put("Buffer", "fv");
	classHookMap.put("GameShell", "bn");
	classHookMap.put("Keyboard", "ae");
	classHookMap.put("ImageRGB", "kd");
	classHookMap.put("IndexedRGB", "ko");
	classHookMap.put("TypeFace", "jg");
	classHookMap.put("Rasterizer3D", "eq");
	classHookMap.put("Rasterizer", "ky");
	classHookMap.put("ClassData", "kr");
	classHookMap.put("Cache", "gr");
	classHookMap.put("Queue", "gq");
	classHookMap.put("HashTable", "gx");
	classHookMap.put("LinkedList", "go");
	classHookMap.put("Cacheable", "gu");
	classHookMap.put("NodeDeque", "go");
	classHookMap.put("Node", "gh");
	*/
	

	player = new RSClass("Player", "bq", RsApplet.loader.loadClass("bq"));
	

}

public static RSClass loadClass(String string) throws ClassNotFoundException {
	String s = classHookMap.get(string);
	return new RSClass(string, s, RsApplet.loader.loadClass(s));
}

public static void updateHooks() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException {
	updateClientHooks();
	
	
}

public static void updateClientHooks() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException {
	getClientWeight();
	getClientEnergy();
	getClientCurrentWorld();
	getClientExperiences();
	getClientRealLevels();
	getClientCurrentLevels();
}

public static int[] getClientExperiences() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException {
	return (int[]) getStaticValue(fieldHookMap.get("Client_Experiences"));
}

public static int getClientWeight() {
	int i = fixStaticModInt(fieldHookMap.get("Client_Weight"));
	HookDebugger.weight=i;
	return i;
}

public static int getClientEnergy() {
	int i = fixStaticModInt(fieldHookMap.get("Client_Energy"));
	HookDebugger.energy=i;
	return i;
}

public static int getClientCurrentWorld() throws IllegalArgumentException, IllegalAccessException {
	int i = (int)fixStaticModInt(fieldHookMap.get("Client_CurrentWorld"));
	HookDebugger.world=i;
	return i;
}

public static int[] getClientRealLevels() throws IllegalArgumentException, IllegalAccessException {
	return (int[])getStaticValue(fieldHookMap.get("Client_RealLevels"));
}

public static int[] getClientCurrentLevels() throws IllegalArgumentException, IllegalAccessException {
	return (int[])getStaticValue(fieldHookMap.get("Client_CurrentLevels"));
}

public static Field getField(RSClass clasz, String field) throws NoSuchFieldException, SecurityException, ClassNotFoundException {
	return RsApplet.loader.loadClass(clasz.getObfuscatedName()).getDeclaredField(field);
}

public static int fixStaticModInt(RSField rsf) {
	return (int)rsf.getValue(null)*rsf.getMultiplier();
}

public static Object getNonStaticValue(RSField f) throws IllegalArgumentException, IllegalAccessException {
	
	return f.getField().get(RsApplet.clientBootClass);
	
}

public static Object getStaticValue(RSField f) throws IllegalArgumentException, IllegalAccessException {
	
	return f.getField().get(null);
	
}

}
