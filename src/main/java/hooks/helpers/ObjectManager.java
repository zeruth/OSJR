package hooks.helpers;

import java.util.HashMap;

import game.Game;
import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.DecorativeObject;
import hooks.accessors.GameObject;
import hooks.accessors.GroundObject;
import hooks.accessors.Tile;
import paint.agility.AgilityObjects;

public class ObjectManager {
	
	public int basex = 0, basey = 0;
	static int[] i = new int[30000];
	
	public static HashMap<Integer, GameObject> gameObjects = new HashMap<>();
	public static HashMap<Integer, DecorativeObject> decorativeObjects = new HashMap<>();
	public static HashMap<Integer, GroundObject> groundObjects = new HashMap<>();
	
	public AgilityObjects agilityObjects = new AgilityObjects();
	
	
	
	public Thread t = new Thread(Game.threadGroup, new Runnable() {

		@Override
		public void run() {
			while (true != false) {
				if (Hooks.client != null) {
					if (Client.isLoaded())
						if (Hooks.client.isLoggedIn()) {
							if (ObjectManager.this.basex != Client.getBaseX() || ObjectManager.this.basey != Client.getBaseY()) {
								resetObjects();
								ObjectManager.this.basex = Client.getBaseX();
								ObjectManager.this.basey = Client.getBaseY();
							}
							if (Client.getRegion() != null) {
								if (Client.getRegion().getTiles() != null) {
									for (Tile t : Client.getRegion().getTiles()) {
										AgilityObjects.checkAgilityObjects(t);
									}
								}
							}
						} else {
							resetObjects();
						}

				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	});
	

	public static void addGameObject(GameObject d) {
		if (i[d.getID()] != 1) {
			gameObjects.put(d.getID(), d);
			i[d.getID()] = 1;
		}
	}

	public static void addDecorativeObject(DecorativeObject d) {
		if (i[d.getID()] != 1) {
			decorativeObjects.put(d.getID(), d);
			i[d.getID()] = 1;
		}
	}

	public static void addGroundObject(GroundObject d) {
		if (i[d.getID()] != 1) {
			groundObjects.put(d.getID(), d);
			i[d.getID()] = 1;
		}
	}
	
	public static void resetObjects() {
		i = new int[30000];
		gameObjects = new HashMap<>();
		decorativeObjects = new HashMap<>();
		groundObjects = new HashMap<>();
	}

}
