package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import game.Settings;
import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.GameObject;
import hooks.helpers.GameObjectListener;
import hooks.helpers.LocalPoint;
import hooks.helpers.Perspective;
import hooks.helpers.Point;

public class GameObjects implements PaintListener {

	@Override
	public void onRepaint(Graphics g) {
		g.setColor(Color.yellow);
		if (Settings.SHOW_GAMEOBJECT_IDS)
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					for (ArrayList<GameObject> gos : GameObjectListener.gameObjects.values()) {
						GameObject go = gos.get(0);
						if (go.getPlane() == Client.getPlane()) {
							String name = "" + go.getID() + "p: " + go.getPlane() + " x:" + go.getX() + " y:"
									+ go.getY();
							Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
									new LocalPoint(go.getX(), go.getY()), name, 0);
							if (p != null && name != null && name.compareTo("null") != 0)
								g.drawString(name, p.getX(), p.getY());
						}
					}
				}

	}

}
