package paint.agility;

import hooks.accessors.DecorativeObject;
import hooks.accessors.GameObject;
import hooks.accessors.GroundObject;
import hooks.accessors.Tile;
import hooks.helpers.ObjectManager;

public class AgilityObjects {

	// Al Kharid
	public static DecorativeObject AL_KHARID_1 = new DecorativeObject(null);
	public static GroundObject AL_KHARID_2 = new GroundObject(null);
	public static GameObject AL_KHARID_3 = new GameObject(null);
	public static GroundObject AL_KHARID_4 = new GroundObject(null);
	public static GameObject AL_KHARID_5 = new GameObject(null);
	public static DecorativeObject AL_KHARID_6 = new DecorativeObject(null);
	public static GroundObject AL_KHARID_7 = new GroundObject(null);
	public static GameObject AL_KHARID_8 = new GameObject(null);

	// Varrock
	public static DecorativeObject VARROCK_1 = new DecorativeObject(null);
	public static GameObject VARROCK_2 = new GameObject(null);
	public static GameObject VARROCK_3 = new GameObject(null);
	public static GameObject VARROCK_4 = new GameObject(null);
	public static GameObject VARROCK_5 = new GameObject(null);
	public static GameObject VARROCK_6 = new GameObject(null);
	public static GameObject VARROCK_7 = new GameObject(null);
	public static GameObject VARROCK_8 = new GameObject(null);
	public static GameObject VARROCK_9 = new GameObject(null);

	// Canifis
	public static GameObject CANIFIS_1 = new GameObject(null);
	public static GameObject CANIFIS_2 = new GameObject(null);
	public static GameObject CANIFIS_3 = new GameObject(null);
	public static GameObject CANIFIS_4 = new GameObject(null);
	public static GameObject CANIFIS_5 = new GameObject(null);
	public static GameObject CANIFIS_6 = new GameObject(null);
	public static GameObject CANIFIS_7 = new GameObject(null);
	public static GameObject CANIFIS_8 = new GameObject(null);
	
	public static void checkAgilityObjects(Tile t) {
		for (GameObject go : t.getObjects()) {
			if (go != null) {
				if (ObjectManager.gameObjects.containsKey(go.getID())) {
					continue;
				}
				switch (go.getID()) {

				// Al Kharid course
				case 10355:
					AL_KHARID_3 = go;
					ObjectManager.addGameObject(AL_KHARID_3);
					break;
				case 10357:
					AL_KHARID_5 = go;
					ObjectManager.addGameObject(AL_KHARID_3);
					break;
				case 10352:
					AL_KHARID_8 = go;
					ObjectManager.addGameObject(AL_KHARID_8);
					break;

				// Varrock

				case 10587:
					VARROCK_2 = go;
					ObjectManager.addGameObject(VARROCK_2);
					break;
				case 10642:
					VARROCK_3 = go;
					ObjectManager.addGameObject(VARROCK_3);
					break;
				case 10777:
					VARROCK_4 = go;
					ObjectManager.addGameObject(VARROCK_4);
					break;
				case 10778:
					VARROCK_5 = go;
					ObjectManager.addGameObject(VARROCK_5);
					break;
				case 10779:
					VARROCK_6 = go;
					ObjectManager.addGameObject(VARROCK_6);
					break;
				case 10780:
					VARROCK_7 = go;
					ObjectManager.addGameObject(VARROCK_7);
					break;
				case 10781:
					VARROCK_8 = go;
					ObjectManager.addGameObject(VARROCK_8);
					break;
				case 10817:
					VARROCK_9 = go;
					ObjectManager.addGameObject(VARROCK_9);
					break;

				// Canifis
				case 10819:
					CANIFIS_1 = go;
					ObjectManager.addGameObject(CANIFIS_1);
					break;
				case 10820:
					CANIFIS_2 = go;
					ObjectManager.addGameObject(CANIFIS_2);
					break;
				case 10821:
					CANIFIS_3 = go;
					ObjectManager.addGameObject(CANIFIS_3);
					break;
				case 10828:
					CANIFIS_4 = go;
					ObjectManager.addGameObject(CANIFIS_4);
					break;
				case 10822:
					CANIFIS_5 = go;
					ObjectManager.addGameObject(CANIFIS_5);
					break;
				case 10831:
					CANIFIS_6 = go;
					ObjectManager.addGameObject(CANIFIS_6);
					break;
				case 10823:
					CANIFIS_7 = go;
					ObjectManager.addGameObject(CANIFIS_7);
					break;
				case 10832:
					CANIFIS_8 = go;
					ObjectManager.addGameObject(CANIFIS_8);
					break;
				}
			}
		}

		if (t != null) {
			if (t.getDecorativeObject() != null) {
				if (ObjectManager.decorativeObjects
						.containsKey(t.getDecorativeObject().getID())) {
					return;
				}
				switch (t.getDecorativeObject().getID()) {

				// Al Kharid course
				case 10093:
					AL_KHARID_1 = t.getDecorativeObject();
					ObjectManager.addDecorativeObject(AL_KHARID_1);
					break;
				case 10094:
					AL_KHARID_6 = t.getDecorativeObject();
					AL_KHARID_6.plane = 2;
					ObjectManager.addDecorativeObject(AL_KHARID_6);
					break;

				// Varrock course
				case 10586:
					VARROCK_1 = t.getDecorativeObject();
					ObjectManager.addDecorativeObject(VARROCK_1);
					break;
				}
			}
		}

		if (t != null) {
			if (t.getGroundObject() != null) {
				if (ObjectManager.groundObjects.containsKey(t.getGroundObject().getID())) {
					return;
				}
				if (t.getGroundObject() != null)
					switch (t.getGroundObject().getID()) {
					// Al Kharid Course
					case 10284:
						AL_KHARID_2 = t.getGroundObject();
						AL_KHARID_2.plane = 3;
						ObjectManager.addGroundObject(AL_KHARID_2);
						break;
					case 10527:
						AL_KHARID_4 = t.getGroundObject();
						AL_KHARID_4.plane = 3;
						ObjectManager.addGroundObject(AL_KHARID_4);
						break;
					case 10583:
						AL_KHARID_7 = t.getGroundObject();
						AL_KHARID_7.plane = 3;
						ObjectManager.addGroundObject(AL_KHARID_7);
						break;

					}
			}
		}

	}

}
