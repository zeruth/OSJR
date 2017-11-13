package com.osshell.util;

import java.lang.reflect.Field;

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
	
public static void setHooks() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
	client = new RSClass("Client", "client", RsApplet.loader.loadClass("client"));
	client_experiences = new RSField("client_experiences", getField(client, "il"), 1);
	client_weight = new RSField("client_weight", getField(client, "kz"), 911960287);
	client_energy = new RSField("client_energy", getField(client, "kb"), 2121080715);
	player = new RSClass("Player", "bq", RsApplet.loader.loadClass("bq"));
	

}

public static void updateHooks() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException {
	getXpTable();
	getClientWeight();
	getClientEnergy();
}

public static int[] getXpTable() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException {
	System.out.println("XP table hooked.");	
	return (int[]) client_experiences.getValue(null);
}

public static int getClientWeight() {
	int i = fixStaticModInt(client_weight);
	System.out.println("Client weight hooked: "+i);	
	return i;
}

public static int getClientEnergy() {
	int i = fixStaticModInt(client_energy);
	System.out.println("Client energy hooked: "+i);	
	return i;
}

public static Field getField(RSClass clasz, String field) throws NoSuchFieldException, SecurityException, ClassNotFoundException {
	return RsApplet.loader.loadClass(clasz.getObfuscatedName()).getDeclaredField(field);
}

public static int fixStaticModInt(RSField rsf) {
	return (int)rsf.getValue(null)*rsf.getMultiplier();
}

public static Object getNonStaticValue(Field f) throws IllegalArgumentException, IllegalAccessException {
	
	return f.get(RsApplet.clientBootClass);
	
}

public static Object getStaticValue(Field f) throws IllegalArgumentException, IllegalAccessException {
	
	return f.get(null);
	
}

}
