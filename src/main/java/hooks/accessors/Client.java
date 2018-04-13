package hooks.accessors;

import java.awt.Canvas;
import java.util.Map;

import game.LoaderWindow;
import hooks.Hooks;
import hooks.model.RSClass;

public class Client extends RSClass {

	public static boolean loggedIn = false;
	int loginState;
	int gameState;
	int scale;

	Player[] cachedPlayers;
	Npc[] cachedNPCs;

	Object[] tempObjects;
	Player tempPlayer;
	Npc tempNPC;

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
		this.tempObjects = (Object[]) getValue(getField("cachedNPCs"));
		if (this.tempObjects != null) {
			int i = 0;
			this.cachedNPCs = new Npc[this.tempObjects.length];
			for (Object o : this.tempObjects) {
				if (o != null) {
					this.tempNPC = new Npc(o);
					this.cachedNPCs[i] = this.tempNPC;
					i++;
				}
			}
			return this.cachedNPCs;
		}
		return null;
	}

	public Player[] getCachedPlayers() {
		this.tempObjects = (Object[]) getValue(getField("cachedPlayers"));
		if (this.tempObjects != null) {
			int i = 0;
			this.cachedPlayers = new Player[this.tempObjects.length];
			for (Object o : this.tempObjects) {
				if (o != null) {
					this.tempPlayer = new Player(o);
					this.cachedPlayers[i] = this.tempPlayer;
					i++;
				}
			}
			return this.cachedPlayers;
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
		this.gameState = (int) getValue(getField("gameState"));
		return this.gameState;
	}

	public static Player getLocalPlayer() {
		return Hooks.soundTaskDataProvider.getLocalPlayer();
	}

	public int getLoginState() {
		this.loginState = (int) getValue(getField("loginState"));
		return this.loginState;
	}

	public int getMapAngle() {
		return (int) getValue(getField("mapAngle"));
	}

	public static int getPlane() {
		return Hooks.boundingBox3DDrawMode.getPlane();
	}

	public int getWidgetRoot() {
		return (int) getValue(getField("widgetRoot"));
	}

	public static Region getRegion() {
		if (Hooks.class255 == null)
			return null;
		return Hooks.class255.getRegion();
	}

	public int getScale() {
		this.scale = (int) getValue(getField("scale"));
		return this.scale;
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
		return (getLoginState() == 10 && getGameState() >= 11 && loggedIn == true);
	}

	public boolean isResized() {
		return (boolean) getValue(getField("isResized"));
	}

	public static Map<Integer, Object> getChatLineMap() {
		return Hooks.class95.getChatLineMap();
	}

	public static ClanMemberManager getClanMemberManager() {
		return Hooks.gameEngine.getClanMemberManager();
	}

	public int getCycle() {
		return (int) getValue(getField("cycleCntr"));
	}
}
