package os.jr.game.accessors;

import java.lang.reflect.Array;

import os.jr.hooks.model.RSClass;
import os.jr.hooks.model.RSField;
import os.jr.utils.Settings;

public class Client extends GameObject{

	public static RSClass client;
	private Cache cache;
	public static boolean loggedIn = false;
	public static Settings settings;

	public Client(Object reference) {
		obj = reference;
		this.hash = System.identityHashCode(this);
	}
	
	public Cache getCache() {
		return cache;
	}
	
	public int[] getExperiences() {

		try {
			RSField field = client.getField("Client_Experiences");
			Object arr = field.getValue(obj);
			int length = Array.getLength(arr);
			int[] experiences = new int[length];
			for (int i = 0; i < length; i++) {
				experiences[i] = (int) Array.get(arr, i);
			}
			return experiences;
		} finally {
			
		}

	}
	
	public int getEnergy() {
		try {
			RSField field = client.getField("Client_Energy");
			int i = (int) field.getValue(obj);
			this.getCache().put("Client_Energy" + hash, i);
			return i;
		} finally {
			
		}
		
	}
	
	public Player[] getPlayers() {
		Object array = client.getField("Client_LocalPlayers").getValue(obj);
		if (array == null)
			return null;

		int length = Array.getLength(array);
		Player[] arr = new Player[length];
		int nonNullCount = 0;
		for (int i = 0; i < length; i++) {
			Object o = Array.get(array, i);
			if (o != null) {
				nonNullCount++;
				arr[i] = new Player(o, this);
			}
		}

		Player[] finalArr = new Player[nonNullCount];
		int ct = 0;
		for (Player p : arr) {
			if (p != null) {
				finalArr[ct] = p;
				ct++;
			}
		}
		return finalArr;
	}
	
	public Player getLocalPlayer() {
		if (client.getField("Client_LocalPlayer")!=null) {
			Object lp = client.getField("Client_LocalPlayer").getValue(obj);
				return new Player(lp, this);
		}
		return null;


	}
	
	public int getWeight() {
		try {
			RSField field = client.getField("Client_Weight");
			int i = (int) field.getValue(obj);
			return i;
		} finally {
			
		}
	}
	
	public int getLoginState() {

		try {
			RSField field = client.getField("Client_LoginState");
			int i = (int) field.getValue(obj);
			return i;
		} finally {
			
		}
	}
	public int getGameState() {

		try {
			RSField field = client.getField("Client_GameState");
			int i = (int) field.getValue(obj);
			return i;
		} finally {
			
		}
	}
}
