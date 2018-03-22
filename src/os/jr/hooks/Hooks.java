package os.jr.hooks;

import java.util.HashMap;

import os.jr.game.RSGame;
import os.jr.hooks.model.RSClass;

public class Hooks {

	public static Hooks selector;
	public static HashMap<String, String> classNames = new HashMap<String, String>();
	public static HashMap<String, String> refactoredClassNames = new HashMap<String, String>();
	public static RSClass[] collection = new RSClass[400];

	public static void init() {
		try {
			selector = new Hooks(); // All hooks must be valid for this to succeed. Easy out-dated check.
		} catch (Exception e) {
			System.out.println("Client hooks outdated. Please update from github or update hooks yourself.");
			System.out.println("Running without hooks.");
			RSGame.outdated = true;
			e.printStackTrace();
		}

	}

	public static RSClass getClassbyName(String name) {
		if (name.compareTo("Client") == 0) {
			return selector.client;
		}
		if (!name.startsWith("class"))
		System.out.println(name + " not loaded.");
		return null;
	}

	// Creates selectable instances of your hooks.
	public Client client = new Client(null);
	// public Widget widget = new Widget(null); etc.
}
