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

	public int getBaseX() {
		return Hooks.packetNode.getBaseX();
	}

	public int getBaseY() {
		return Hooks.baseVarType.getBaseY();
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

	public int getCameraPitch() {
		return Hooks.boundingBox3D.getCameraPitch();
	}

	public int getCameraX() {
		return Hooks.sequence.getCameraX();
	}

	public int getCameraY() {
		return Hooks.chatLineBuffer.getCameraY();
	}

	public int getCameraYaw() {
		return Hooks.clientPacket.getCameraYaw();
	}

	public int getCameraZ() {
		return Hooks.area.getCameraZ();
	}

	public Canvas getCanvas() {
		return LoaderWindow.game;
	}

	public int getGameState() {
		return (int) getValue(getField("gameState"));
	}

	public Player getLocalPlayer() {
		return Hooks.worldComparator.getLocalPlayer();
	}

	public int getLoginState() {
		return (int) getValue(getField("loginState"));
	}

	public int getMapAngle() {
		return (int) getValue(getField("mapAngle"));
	}

	public int getPlane() {
		return Hooks.class237.getPlane();
	}

	public Region getRegion() {
		if (Hooks.class308 == null)
			return null;
		return Hooks.class308.getRegion();
	}

	public int getScale() {
		return (int) getValue(getField("scale"));
	}

	public int getSetting(int i) {
		return 0;
	}

	public int[] getSettingsArray() {
		return new int[100];
	}

	public int[][][] getTileHeights() {
		return Hooks.class62.getTileHeights();
	}

	public byte[][][] getTileSettings() {
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
}
