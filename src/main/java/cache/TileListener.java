package cache;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.DecorativeObject;
import hooks.accessors.GameObject;
import hooks.accessors.GroundObject;
import hooks.accessors.ItemLayer;
import hooks.accessors.Tile;
import hooks.accessors.WallObject;
import paint.PaintListener;

public class TileListener implements PaintListener {
	private int tick;
	public static HashMap<Integer, DecorativeObject> decorativeObjects = new HashMap<>();
	public static HashMap<Integer, ArrayList<GameObject>> gameObjects = new HashMap<>();
	public static HashMap<Integer, GroundObject> groundObjects = new HashMap<>();
	public static HashMap<Integer, WallObject> wallObjects = new HashMap<>();
	public static ArrayList<ItemLayer> groundItems = new ArrayList<>();


	@Override
	public void onRepaint(Graphics g) {
		if (this.tick > 40) {
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					decorativeObjects = new HashMap<>();
					gameObjects = new HashMap<>();
					groundObjects = new HashMap<>();
					wallObjects = new HashMap<>();
					groundItems = new ArrayList<>();
					
					for (Tile t : Client.getRegion().getTiles()) {
						
						if (t.getItemLayer().reference!=null) {
								groundItems.add(t.getItemLayer());
							}

						if (t.getDecorativeObject() != null) {
							DecorativeObject decObj = t.getDecorativeObject();
							if (decObj != null) {
								decorativeObjects.put(decObj.getID(), decObj);
							}
						}
						
						if (t.getGroundObject() != null) {
							GroundObject groundObj = t.getGroundObject();
							if (groundObj != null) {
								groundObjects.put(groundObj.getID(), groundObj);
							}
						}
						
						if (t.getDecorativeObject() != null) {
							WallObject wallObj = t.getWallObject();
							if (wallObj != null) {
								wallObjects.put(wallObj.getID(), wallObj);
							}
						}
						
						for (GameObject go : t.getObjects()) {
							if (go != null) {
								if (gameObjects.get(go.getID()) == null) {
									ArrayList<GameObject> gos = new ArrayList<>();
									gos.add(go);
									gameObjects.put(go.getID(), gos);
								} else {
									ArrayList<GameObject> gos = gameObjects.get(go.getID());
									if (gos != null && go != null) {
										gos.add(go);
										gameObjects.put(go.getID(), gos);
									}
								}
							}
						}
					}
				}
			this.tick = 0;
		} else {
			this.tick++;
		}

	}

}
