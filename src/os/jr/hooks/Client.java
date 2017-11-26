package os.jr.hooks;

import java.lang.reflect.Field;

import os.jr.boot.Boot;
import os.jr.game.Reflector;
import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;
import os.jr.utils.Settings;

public class Client extends GameClass {
	
	public Object player, actorCombatInfoList, combatInfoListHead, combatInfoListNext, combatInfo2, healthScale;

	public final String CLIENT_ENERGY = "Client_Energy";
	public final String CLIENT_LOCAL_PLAYER = "Client_LocalPlayer";
	public final String CLIENT_LOGIN_STATE = "Client_LoginState";

	public static Settings settings;

	public Client(Object reference) {
		super("client");
		String client = "client";
		this.fields.put("Client_Client", new GameField("az", client));
		this.fields.put("Client_LocalNPCs", new GameField("dr", client));
		this.fields.put("Client_NPCIndices", new GameField("dd", client));
		this.fields.put("Client_LocalPlayers", new GameField("hq", client));
		this.fields.put("Client_PlayerIndices", new GameField("b", "cz"));
		this.fields.put("Client_LocalPlayer", new GameField("iu", "fv"));
		this.fields.put("Client_PlayerIndex", new GameField("ie", client, -1109771377));
		this.fields.put("Client_LoopCycle", new GameField("br", client, 837440703));
		this.fields.put("Client_LoginState", new GameField("bc", client, 892934841));
		this.fields.put("Client_GameState", new GameField("ag", "cq", 1924581473));
		this.fields.put("Client_CrossHairColor", new GameField("hp", client, 105515995));
		this.fields.put("Client_GroundItems", new GameField("ia", client));
		this.fields.put("Client_CollisionMap", new GameField("w", client));
		this.fields.put("Client_TradingPostOffers", new GameField("qq", client));
		this.fields.put("Client_CameraX", new GameField("gd", "hn", -623009039));
		this.fields.put("Client_CameraY", new GameField("gh", "kk", 1589273571));
		this.fields.put("Client_CameraZ", new GameField("gv", "bs", 2111392483));
		this.fields.put("Client_CameraPitch", new GameField("gu", "e", 710716633));
		this.fields.put("Client_CameraYaw", new GameField("go", "at", -1914160081));
		this.fields.put("Client_Region", new GameField("ff", "y"));
		this.fields.put("Client_Plane", new GameField("ij", "hq", -1437699907));
		this.fields.put("Client_BaseX", new GameField("eg", "id", 480327827));
		this.fields.put("Client_BaseY", new GameField("ek", "ez", 1709641349));
		this.fields.put("Client_DestinationX", new GameField("nc", client, -772373357));
		this.fields.put("Client_DestinationY", new GameField("nd", client, -797410031));
		this.fields.put("Client_Sine", new GameField("a", "em"));
		this.fields.put("Client_Cosine", new GameField("ah", "em"));
		this.fields.put("Client_TileHeights", new GameField("d", "bz"));
		this.fields.put("Client_TileSettings", new GameField("x", "bz"));
		this.fields.put("Client_Widgets", new GameField("m", "u"));
		this.fields.put("Client_GameSettings", new GameField("hd", "k"));
		this.fields.put("Client_WidgetNodeCache", new GameField("ki", client));
		this.fields.put("Client_WidgetPositionX", new GameField("mp", client));
		this.fields.put("Client_WidgetPositionY", new GameField("mh", client));
		this.fields.put("Client_WidgetWidths", new GameField("ms", client));
		this.fields.put("Client_WidgetHeights", new GameField("mw", client));
		this.fields.put("Client_ViewPortWidth", new GameField("pc", client, 143084651));
		this.fields.put("Client_ViewPortHeight", new GameField("pz", client, -820592493));
		this.fields.put("Client_MapAngle", new GameField("gy", client, -479093555));
		//this.fields.put("Client_MapScale", new GameField("jb", client, -1323797235)); N/A
		//this.fields.put("Client_MapOffset", new GameField("jk", client, -1323797235)); N/A
		this.fields.put("Client_MenuCount", new GameField("jb", client, 385951891));
		this.fields.put("Client_MenuActions", new GameField("jk", client));
		this.fields.put("Client_MenuOptions", new GameField("ju", client));
		this.fields.put("Client_IsMenuOpen", new GameField("il", client));
		this.fields.put("Client_MenuX", new GameField("ic", "fs", 1221144581));
		this.fields.put("Client_MenuY", new GameField("iq", "x", -1696751693));
		this.fields.put("Client_MenuWidth", new GameField("jl", "aq", 2072173321));
		this.fields.put("Client_MenuHeight", new GameField("jh", "cq", 618653029));
		this.fields.put("Client_CurrentLevels", new GameField("iw", client));
		this.fields.put("Client_RealLevels", new GameField("ik", client));
		this.fields.put("Client_Experiences", new GameField("is", client));
		this.fields.put("Client_CurrentWorld", new GameField("bj", client, -2044727567));
		this.fields.put("Client_Energy", new GameField("kw", client, -1323797235));
		this.fields.put("Client_Weight", new GameField("kb", client, -476166197));
	}

	public long getClientEnergy() {
		System.out.println((int) getFieldValue(CLIENT_ENERGY, null));
		return (int) getFieldValue(CLIENT_ENERGY, null);
	}
	
	public Player getPlayer() {
		return Hooks.selector.player;
	}
	
	public Player getLocalPlayer() {
		Client c = Hooks.selector.client;
		player = c.fields.get(CLIENT_LOCAL_PLAYER).getValue(Boot.rootReference);
		return new Player(player);
	}
	
	public int getLoginState() {
		Client c = Hooks.selector.client;
		return (int) c.getFieldValue(CLIENT_LOGIN_STATE, c);
	}
	
	public boolean isLoggedIn() {
		if (getLoginState()==30) {
			return true;
		}
		return false;
	}

}
