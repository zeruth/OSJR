package hooks.accessors;

import java.awt.Canvas;

import game.LoaderWindow;
import hooks.Hooks;
import hooks.model.RSClass;

public class Client extends RSClass {

	public static boolean isLoaded() {
		try {
			Hooks.client.getLoginState();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Client(Object reference) {
		this.reference = reference;
		if (Hooks.client != null) {
			this.fields = Hooks.client.fields;
			this.name = Hooks.client.name;
			this.obfuscatedName = Hooks.client.obfuscatedName;
		}
	}

	public static int getBaseX() {
		return Hooks.class138.getBaseX();
	}

	public static int getBaseY() {
		return Hooks.class23.getBaseY();
	}

	public Npc[] getCachedNpcs() {
		Object[] os = (Object[]) getValue(getField("cachedNPCs"));
		if (os != null) {
			int i = 0;
			Npc[] ps = new Npc[os.length];
			for (Object o : os) {
				if (o != null) {
					ps[i] = new Npc(o);
					i++;
				}
			}
			return ps;
		}
		return null;
	}

	public Player[] getCachedPlayers() {
		Object[] os = (Object[]) getValue(getField("cachedPlayers"));
		if (os != null) {
			int i = 0;
			Player[] ps = new Player[os.length];
			for (Object o : os) {
				if (o != null) {
					ps[i] = new Player(o);
					i++;
				}
			}
			return ps;
		}
		return null;

	}

	public int[] getRealSkillLevels() {
		return (int[]) getValue(getField("realSkillLevels"));
	}

	public int[] getExperiences() {
		return (int[]) getValue(getField("skillExperiences"));
	}

	public static int getCameraPitch() {
		return Hooks.grandExchangeOffer.getCameraPitch();
	}

	public static int getCameraX() {
		return Hooks.player.getCameraX();
	}

	public static int getCameraY() {
		return Hooks.class20.getCameraY();
	}

	public static int getCameraYaw() {
		return Hooks.class28.getCameraYaw();
	}

	public static int getCameraZ() {
		return Hooks.gameObject.getCameraZ();
	}

	public static Canvas getCanvas() {
		return LoaderWindow.game;
	}

	public int getGameState() {
		return (int) getValue(getField("gameState"));
	}

	public static Player getLocalPlayer() {
		return Hooks.soundTaskDataProvider.getLocalPlayer();
	}

	public int getLoginState() {
		return (int) getValue(getField("loginState"));
	}

	public int getMapAngle() {
		return (int) getValue(getField("mapAngle"));
	}

	public static int getPlane() {
		return Hooks.boundingBox3DDrawMode.getPlane();
	}

	public static Region getRegion() {
		if (Hooks.class255 == null)
			return null;
		return Hooks.class255.getRegion();
	}

	public int getScale() {
		return (int) getValue(getField("scale"));
	}

	public static int getSetting(int i) {
		return 0;
	}

	public static int[] getSettingsArray() {
		return new int[100];
	}

	public static int[][][] getTileHeights() {
		return Hooks.class62.getTileHeights();
	}

	public static byte[][][] getTileSettings() {
		return Hooks.class62.getTileSettings();
	}

	public int getViewportHeight() {
		return (int) getValue(getField("viewportHeight"));
	}

	public int getViewportWidth() {
		return (int) getValue(getField("viewportWidth"));
	}

	public boolean isLoggedIn() {
		return (getLoginState() == 10 && getGameState() >= 11);
	}

	public boolean isResized() {
		return (boolean) getValue(getField("isResized"));
	}

	public static ClanMemberManager getClanMemberManager() {
		return Hooks.gameEngine.getClanMemberManager();
	}
}
