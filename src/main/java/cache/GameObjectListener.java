package cache;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.GameObject;
import hooks.accessors.Tile;
import paint.PaintListener;

public class GameObjectListener implements PaintListener {
	private int tick;
	public static HashMap<Integer, ArrayList<GameObject>> gameObjects = new HashMap<>();

	@Override
	public void onRepaint(Graphics g) {
		if (this.tick > 40) {
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					for (Tile t : Client.getRegion().getTiles()) {
						if (t.getObjects() != null)
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
