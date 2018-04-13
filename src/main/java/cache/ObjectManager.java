package cache;

import java.awt.Color;
import java.util.HashMap;

import hooks.Hooks;
import hooks.accessors.Client;

public class ObjectManager {

	public static Color fillColor = new Color(Color.YELLOW.getBlue(), Color.YELLOW.getGreen(), Color.YELLOW.getRed(),
			50);
	public static Color outlineColor = Color.YELLOW;
	public int basex = 0, basey = 0;

	public Thread t = new Thread(new Runnable() {

		@Override
		public void run() {
			while (true != false) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (Hooks.client != null) {
					if (Client.isLoaded())
						if (Hooks.client.isLoggedIn()) {
							if (ObjectManager.this.basex != Client.getBaseX()
									|| ObjectManager.this.basey != Client.getBaseY()) {
							} else {
								resetObjects();
							}
						}
				}
			}
		}
	});

	public static void resetObjects() {
		DecorativeObjectListener.decorativeObjects = new HashMap<>();
		WallObjectListener.wallObjects = new HashMap<>();
		GroundObjectListener.groundObjects = new HashMap<>();
		GameObjectListener.gameObjects = new HashMap<>();
	}

}
