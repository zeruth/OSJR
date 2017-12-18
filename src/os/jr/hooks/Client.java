package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;
import os.jr.utils.Settings;

public class Client extends GameClass {

	public static final String client = "client";
	public static final String field_Client = "ar";
	public static final String field_LocalNPCs = "dm";
	public static final String field_NPCIndices = "dq";
	public static final String field_LocalPlayers = "ie";
	public static final String field_PlayerIndices = "t";
	public static final String field_LocalPlayer = "ii";
	public static final String field_PlayerIndex = "ig";
	public static final String field_LoopCycle = "bt";
	public static final String field_LoginState = "bh";
	public static final String field_GameState = "aw";
	public static final String field_CrossHairColor = "hl";
	public static final String field_GroundItems = "io";
	public static final String field_CollisionMap = "w";
	public static final String field_TradingPostOffers = "qn";
	public static final String field_CameraX = "gg";
	public static final String field_CameraY = "gz";
	public static final String field_CameraZ = "gd";
	public static final String field_CameraPitch = "gs";
	public static final String field_CameraYaw = "gy";
	public static final String field_Region = "fi";
	public static final String field_Plane = "iy";
	public static final String field_BaseX = "et";
	public static final String field_BaseY = "ee";
	public static final String field_DestinationX = "na";
	public static final String field_DestinationY = "ni";
	public static final String field_Sine = "p";
	public static final String field_Cosine = "ab";
	public static final String field_TileHeights = "a";
	public static final String field_TileSettings = "w";
	public static final String field_Widgets = "z";
	public static final String field_GameSettings = "e";
	public static final String field_WidgetNodeCache = "kb";
	public static final String field_WidgetPositionX = "mi";
	public static final String field_WidgetPositionY = "mf";
	public static final String field_WidgetWidths = "mr";
	public static final String field_WidgetHeights = "mb";
	public static final String field_ViewPortWidth = "pd";
	public static final String field_ViewPortHeight = "pa";
	public static final String field_MapAngle = "gb";
	public static final String field_MapScale = null;
	public static final String field_MapOffset = null;
	public static final String field_MenuCount = "jg";
	public static final String field_MenuActions = "jn";
	public static final String field_MenuOptions = "jh";
	public static final String field_IsMenuOpen = "ip";
	public static final String field_MenuX = "ir";
	public static final String field_MenuY = "jc";
	public static final String field_MenuWidth = "jw";
	public static final String field_MenuHeight = "jk";
	public static final String field_CurrentLevels = "if";
	public static final String field_RealLevels = "ic";
	public static final String field_Experiences = "iw";
	public static final String field_CurrentWorld = "bb";
	public static final String field_Energy = "kx";
	public static final String field_Weight = "kg";

	public static final String field_PlayerIndices_Parent = "cy";
	public static final String field_LocalPlayer_Parent = "ep";
	public static final String field_GameState_Parent = "cr";
	public static final String field_CameraX_Parent = "bx";
	public static final String field_CameraY_Parent = "fd";
	public static final String field_CameraZ_Parent = "y";
	public static final String field_CameraPitch_Parent = "fm";
	public static final String field_CameraYaw_Parent = "im";
	public static final String field_Region_Parent = "aj";
	public static final String field_Plane_Parent = "g";
	public static final String field_BaseX_Parent = "am";
	public static final String field_Sine_Parent = "es";
	public static final String field_Cosine_Parent = "es";
	public static final String field_TileHeights_Parent = "bf";
	public static final String field_TileSettings_Parent = "bf";
	public static final String field_Widgets_Parent = "hz";
	public static final String field_GameSettings_Parent = "hs";
	public static final String field_MenuX_Parent = "as";
	public static final String field_MenuY_Parent = "fo";
	public static final String field_MenuWidth_Parent = "cg";
	public static final String field_MenuHeight_Parent = "v";

	public static final int field_PlayerIndex_multiplier = 273517695;
	public static final int field_LoopCycle_multiplier = 400517435;
	public static final int field_LoginState_multiplier = -41679833;
	public static final int field_GameState_multiplier = 773237997;
	public static final int field_CrossHairColor_multiplier = 52368887;
	public static final int field_CameraX_multiplier = -245636329;
	public static final int field_CameraY_multiplier = -219460773;
	public static final int field_CameraZ_multiplier = 508599443;
	public static final int field_CameraPitch_multiplier = -1636862767;
	public static final int field_CameraYaw_multiplier = -1524418041;
	public static final int field_Plane_multiplier = -1321200933;
	public static final int field_BaseX_multiplier = -1917457925;
	public static final int field_BaseY_multiplier = -1694947901;
	public static final int field_DestinationX_multiplier = -710720663;
	public static final int field_DestinationY_multiplier = -118830161;
	public static final int field_ViewPortWidth_multiplier = -123028359;
	public static final int field_ViewPortHeight_multiplier = -1020819321;
	public static final int field_MapAngle_multiplier = -1215179141;
	public static final int field_MenuCount_multiplier = -1716599453;
	public static final int field_MenuX_multiplier = -1945852199;
	public static final int field_MenuY_multiplier = 139833421;
	public static final int field_MenuWidth_multiplier = -2124720277;
	public static final int field_MenuHeight_multiplier = -557930467;
	public static final int field_CurrentWorld_multiplier = -516348683;
	public static final int field_Energy_multiplier = -1863294619;
	public static final int field_Weight_multiplier = -297847855;
	
	public int baseY;
	public int baseX;
	public int[] realLevels;
	public int[] currentLevels;
	public int[] experiences;
	public int loopCycle;
	public int loginState;
	public int gameState;
	public int CurrentWorld;
	public int Energy;
	public int Weight;
	public int cameraX;
	public int cameraY;
	public int cameraZ;
	public int cameraPitch;
	public int cameraYaw;
	public Item[] groundItems;
	public Player[] localPlayers;

	public final String CLIENT_LOCAL_NPCS = "Client_LocalNPCs";
	public final String CLIENT_ENERGY = "Client_Energy";
	public final String CLIENT_LOCAL_PLAYER = "Client_LocalPlayer";
	public final String CLIENT_LOGIN_STATE = "Client_LoginState";
	public final String CLIENT_GAME_STATE = "Client_GameState";
	public final String CLIENT_BASE_X = "Client_BaseX";
	public final String CLIENT_BASE_Y = "Client_BaseY";
	public final String CLIENT_CURRENT_WORLD = "Client_CurrentWorld";
	public final String CLIENT_WEIGHT = "Client_Weight";
	public final String CLIENT_EXPERIENCES = "Client_Experiences";
	public final String CLIENT_REAL_LEVELS = "Client_RealLevels";
	public final String CLIENT_CURRENT_LEVELS = "Client_CurrentLevels";
	public final String CLIENT_CAMERA_X = "Client_CameraX";
	public final String CLIENT_CAMERA_Y = "Client_CameraY";
	public final String CLIENT_CAMERA_Z = "Client_CameraZ";
	public final String CLIENT_CAMERA_PITCH = "Client_CameraPitch";
	public final String CLIENT_CAMERA_YAW = "Client_CameraYaw";
	public final String CLIENT_GROUND_ITEMS = "Client_GroundItems";
	public final String CLIENT_LOCAL_PLAYERS = "Client_LocalPlayers";

	public Object player, actorCombatInfoList, combatInfoListHead, combatInfoListNext, combatInfo2, healthScale;

	public static Settings settings;

	public Client(Object reference) {
		super(client);
		this.fields.put("Client_Client", new GameField(field_Client, client));
		this.fields.put("Client_LocalNPCs", new GameField(field_LocalNPCs, client));
		this.fields.put("Client_NPCIndices", new GameField(field_NPCIndices, client));
		this.fields.put("Client_LocalPlayers", new GameField(field_LocalPlayers, client));
		this.fields.put("Client_PlayerIndices", new GameField(field_PlayerIndices, field_PlayerIndices_Parent));
		this.fields.put("Client_LocalPlayer", new GameField(field_LocalPlayer, field_LocalPlayer_Parent));
		this.fields.put("Client_PlayerIndex", new GameField(field_PlayerIndex, client, field_PlayerIndex_multiplier));
		this.fields.put("Client_LoopCycle", new GameField(field_LoopCycle, client, field_LoopCycle_multiplier));
		this.fields.put("Client_LoginState", new GameField(field_LoginState, client, field_LoginState_multiplier));
		this.fields.put("Client_GameState",
				new GameField(field_GameState, field_GameState_Parent, field_GameState_multiplier));
		
		this.fields.put("Client_CrossHairColor",
				new GameField(field_CrossHairColor, client, field_CrossHairColor_multiplier));
		
		this.fields.put("Client_GroundItems", new GameField(field_GroundItems, client));
		this.fields.put("Client_CollisionMap", new GameField(field_CollisionMap, client));
		this.fields.put("Client_TradingPostOffers", new GameField(field_TradingPostOffers, client));
		this.fields.put("Client_CameraX", new GameField(field_CameraX, field_CameraX_Parent, field_CameraX_multiplier));
		this.fields.put("Client_CameraY", new GameField(field_CameraY, field_CameraY_Parent, field_CameraY_multiplier));
		this.fields.put("Client_CameraZ", new GameField(field_CameraZ, field_CameraZ_Parent, field_CameraZ_multiplier));
		this.fields.put("Client_CameraPitch",
				new GameField(field_CameraPitch, field_CameraPitch_Parent, field_CameraPitch_multiplier));
		
		this.fields.put("Client_CameraYaw",
				new GameField(field_CameraYaw, field_CameraYaw_Parent, field_CameraYaw_multiplier));
		
		this.fields.put("Client_Region", new GameField(field_Region, field_Region_Parent));
		this.fields.put("Client_Plane", new GameField(field_Plane, field_Plane_Parent, field_Plane_multiplier));
		this.fields.put("Client_BaseX", new GameField(field_BaseX, field_BaseX_Parent, field_BaseX_multiplier));
		this.fields.put("Client_BaseY", new GameField(field_BaseY, client, field_BaseY_multiplier));
		this.fields.put("Client_DestinationX",
				new GameField(field_DestinationX, client, field_DestinationX_multiplier));
		
		this.fields.put("Client_DestinationY",
				new GameField(field_DestinationY, client, field_DestinationY_multiplier));
		
		this.fields.put("Client_Sine", new GameField(field_Sine, field_Sine_Parent));
		this.fields.put("Client_Cosine", new GameField(field_Cosine, field_Cosine_Parent));
		this.fields.put("Client_TileHeights", new GameField(field_TileHeights, field_TileHeights_Parent));
		this.fields.put("Client_TileSettings", new GameField(field_TileSettings, field_TileSettings_Parent));
		this.fields.put("Client_Widgets", new GameField(field_Widgets, field_Widgets_Parent));
		this.fields.put("Client_GameSettings", new GameField(field_GameSettings, field_GameSettings_Parent));
		this.fields.put("Client_WidgetNodeCache", new GameField(field_WidgetNodeCache, client));
		this.fields.put("Client_WidgetPositionX", new GameField(field_WidgetPositionX, client));
		this.fields.put("Client_WidgetPositionY", new GameField(field_WidgetPositionY, client));
		this.fields.put("Client_WidgetWidths", new GameField(field_WidgetWidths, client));
		this.fields.put("Client_WidgetHeights", new GameField(field_WidgetHeights, client));
		this.fields.put("Client_ViewPortWidth",
				new GameField(field_ViewPortWidth, client, field_ViewPortWidth_multiplier));
		
		this.fields.put("Client_ViewPortHeight",
				new GameField(field_ViewPortHeight, client, field_ViewPortHeight_multiplier));
		
		this.fields.put("Client_MapAngle", new GameField(field_MapAngle, client, field_MapAngle_multiplier));
		this.fields.put("Client_MenuCount", new GameField(field_MenuCount, client, field_MenuCount_multiplier));
		this.fields.put("Client_MenuActions", new GameField(field_MenuActions, client));
		this.fields.put("Client_MenuOptions", new GameField(field_MenuOptions, client));
		this.fields.put("Client_IsMenuOpen", new GameField(field_IsMenuOpen, client));
		this.fields.put("Client_MenuX", new GameField(field_MenuX, field_MenuX_Parent, field_MenuX_multiplier));
		this.fields.put("Client_MenuY", new GameField(field_MenuY, field_MenuY_Parent, field_MenuY_multiplier));
		this.fields.put("Client_MenuWidth",
				new GameField(field_MenuWidth, field_MenuWidth_Parent, field_MenuWidth_multiplier));
		
		this.fields.put("Client_MenuHeight",
				new GameField(field_MenuHeight, field_MenuHeight_Parent, field_MenuHeight_multiplier));
		
		this.fields.put("Client_CurrentLevels", new GameField(field_CurrentLevels, client));
		this.fields.put("Client_RealLevels", new GameField(field_RealLevels, client));
		this.fields.put("Client_Experiences", new GameField(field_Experiences, client));
		this.fields.put("Client_CurrentWorld",
				new GameField(field_CurrentWorld, client, field_CurrentWorld_multiplier));
		
		this.fields.put("Client_Energy", new GameField(field_Energy, client, field_Energy_multiplier));
		this.fields.put("Client_Weight", new GameField(field_Weight, client, field_Weight_multiplier));
	}
	
	public Player[] getLocalPlayers() {
		Object[] o = (Object[]) fields.get(CLIENT_LOCAL_PLAYERS).getValue(reference);
		Player[] players = new Player[o.length];
		int i = 0;
		for (Object p : o) {
			if (p!=null) {
				players[i] = new Player(p);
			}
			i++;
		}
		return players;
	}
	
	public NPC[] getLocalNPCs() {
		Object[] o = (Object[]) fields.get(CLIENT_LOCAL_NPCS).getValue(reference);
		NPC[] npcs = new NPC[o.length];
		int i = 0;
		for (Object p : o) {
			if (p!=null) {
			npcs[i] = new NPC(p);
			}
			i++;
		}
		return npcs;
	}

	public LocalPlayer getLocalPlayer() {
		Client c = Hooks.selector.client;
		player = c.fields.get(CLIENT_LOCAL_PLAYER).getValue(reference);
		return new LocalPlayer(player);
	}
	
	public int getGameState() {
		int i = (int) fields.get(CLIENT_GAME_STATE).getValue(reference);
		return i;
	}

	public int getLoginState() {
		int i = (int) fields.get(CLIENT_LOGIN_STATE).getValue(reference);
		return i;
	}

	public boolean isLoggedIn() {
		if (getLoginState() == 30) {
			return true;
		}
		return false;
	}

	public int getBaseX() {
		int i = (int) fields.get(CLIENT_BASE_X).getValue(reference);
		return i;
	}

	public int getBaseY() {
		int i = (int) fields.get(CLIENT_BASE_Y).getValue(reference);
		return i;
	}
	
	public int[] getExperiences() {
		int[] i = (int[]) fields.get(CLIENT_EXPERIENCES).getValue(reference);
		return i;
	}
	
	public int[] getRealLevels() {
		int[] i = (int[]) fields.get(CLIENT_REAL_LEVELS).getValue(reference);
		return i;
	}
	
	public int[] getCurrentLevels() {
		int[] i = (int[]) fields.get(CLIENT_CURRENT_LEVELS).getValue(reference);
		return i;
	}
	
	public int getCurrentWorld() {
		int i = (int) getFieldValue(CLIENT_CURRENT_WORLD, reference);
		return i;
	}
	
	public int getEnergy() {
		int i = (int) getFieldValue(CLIENT_ENERGY, reference);
		return i;
	}
	
	public int getWeight() {
		int i = (int) fields.get(CLIENT_WEIGHT).getValue(reference);
		return i;
	}
	
	public int getCameraX() {
		int i = (int) fields.get(CLIENT_CAMERA_X).getValue(reference);
		return i;
	}
	
	public int getCameraY() {
		int i = (int) fields.get(CLIENT_CAMERA_Y).getValue(reference);
		return i;
	}
	
	public int getCameraZ() {
		int i = (int) fields.get(CLIENT_CAMERA_Z).getValue(reference);
		return i;
	}
	
	public int getCameraPitch() {
		int i = (int) fields.get(CLIENT_CAMERA_PITCH).getValue(reference);
		return i;
	}
	
	public int getCameraYaw() {
		int i = (int) fields.get(CLIENT_CAMERA_YAW).getValue(reference);
		return i;
	}

}
