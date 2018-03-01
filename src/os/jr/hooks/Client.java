package os.jr.hooks;

import os.jr.hooks.model.RSClass;

//Simple example of hook impl.
public class Client extends RSClass {

	// Declare field names here for ease later on.
	public static final String widgetCount = "widgetCount";
	public static final String isResized = "isResized";
	public static final String gameDrawingMode = "gameDrawingMode";
	public static final String widgetFlags = "widgetFlags";
	public static final String widgetPositionX = "widgetPositionX";
	public static final String widgetBoundsWidth = "widgetBoundsWidth";
	public static final String widgetPositionY = "widgetPositionY";
	public static final String widgetBoundsHeight = "widgetBoundsHeight";
	public static final String cycleCntr = "cycleCntr";
	public static final String clanChatOwner = "clanChatOwner";
	public static final String clanChatName = "clanChatName";
	public static final String mouseWheelRotation = "mouseWheelRotation";
	public static final String destinationX = "destinationX";
	public static final String destinationY = "destinationY";
	public static final String audioEffects = "audioEffects";
	public static final String interfaceItemTriggers = "interfaceItemTriggers";
	public static final String ignoreCount = "ignoreCount";
	public static final String ignores = "ignores";
	public static final String friendCount = "friendCount";
	public static final String mapIcons = "mapIcons";
	public static final String friends = "friends";
	public static final String publicChatMode = "publicChatMode";
	public static final String Viewport_xOffset = "Viewport_xOffset";
	public static final String Viewport_yOffset = "Viewport_yOffset";
	public static final String viewportHeight = "viewportHeight";
	public static final String viewportWidth = "viewportWidth";
	public static final String scale = "scale";
	public static final String grandExchangeOffers = "grandExchangeOffers";
	public static final String chatCycle = "chatCycle";
	public static final String collisionMaps = "collisionMaps";
	public static final String world = "world";
	public static final String flags = "flags";
	public static final String socketType = "socketType";
	public static final String isMembers = "isMembers";
	public static final String lowMemory = "lowMemory";
	public static final String languageId = "languageId";
	public static final String gameState = "gameState";
	public static final String gameCycle = "gameCycle";
	public static final String mouseLastPressedTimeMillis = "mouseLastLastPressedTimeMillis";
	public static final String displayFps = "displayFps";
	public static final String hintArrowTargetType = "hintArrowTargetType";
	public static final String hintArrowNpcTargetIdx = "hintArrowNpcTargetIdx";
	public static final String hintArrowPlayerTargetIdx = "hintArrowPlayerTargetIdx";
	public static final String hintArrowX = "hintArrowX";
	public static final String hintArrowY = "hintArrowY";
	public static final String hintArrowType = "hintArrowType";
	public static final String hintArrowOffsetX = "hintArrowOffsetX";
	public static final String hintArrowOffsetY = "hintArrowOffsetY";
	public static final String playerAttackOption = "playerAttackOption";
	public static final String npcAttackOption = "npcAttackOption";
	public static final String loadingStage = "loadingStage";
	public static final String js5State = "js5State";
	public static final String loginState = "loginState";
	public static final String cachedNPCs = "cachedNPCs";
	public static final String npcIndexesCount = "npcIndexesCount";
	public static final String npcIndices = "npcIndices";
	public static final String pendingNpcFlagsCount = "pendingNpcFlagsCount";
	public static final String pendingNpcFlagsIndices = "pendingNpcFlagsIndices";
	public static final String socketError = "socketError";
	public static final String fontsMap = "fontsMap";
	public static final String baseY = "baseY";
	public static final String baseX = "baseX";
	public static final String isDynamicRegion = "isDynamicRegion";
	public static final String mapAngle = "mapAngle";
	public static final String screenY = "screenY";
	public static final String screenX = "screenX";
	public static final String cursorState = "cursorState";
	public static final String mouseCrosshair = "mouseCrosshair";
	public static final String cachedPlayers = "cachedPlayers";
	public static final String localInteractingIndex = "localInteractingIndex";
	public static final String playerMenuTypes = "playerMenuTypes";
	public static final String playerOptions = "playerOptions";
	public static final String lastSelectedItemName = "lastSelectedItemName";
	public static final String playerOptionsPriorities = "playerOptionsPriorities";
	public static final String groundItemDeque = "groundItemDeque";
	public static final String pendingSpawns = "pendingSpawns";
	public static final String projectiles = "projectiles";
	public static final String graphicsObjectDeque = "graphicsObjectDeque";
	public static final String boostedSkillLevels = "boostedSkillLevels";
	public static final String realSkillLevels = "realSkillLevels";
	public static final String skillExperiences = "skillExperiences";
	public static final String isMenuOpen = "isMenuOpen";
	public static final String menuOptionCount = "menuOptionCount";
	public static final String menuActionParams0 = "menuActionParams0";
	public static final String menuActionParams1 = "menuActionParams1";
	public static final String menuTypes = "menuTypes";
	public static final String menuIdentifiers = "menuIdentifiers";
	public static final String menuOptions = "menuOptions";
	public static final String menuTargets = "menuTargets";
	public static final String menuBooleanArray = "menuBooleanArray";
	public static final String itemSelectionState = "itemSelectionState";
	public static final String spellSelected = "spellSelected";
	public static final String widgetRoot = "widgetRoot";
	public static final String componentTable = "componentTable";
	public static final String energy = "energy";
	public static final String weight = "weight";
	public static final String rights = "rights";
	public static final String numberMenuOptions = "numberMenuOptions";

	// What should be the only creation on the hook.
	public Client(Object reference) {
		super(Hooks.classNames.get("Client"));

		// ALWAYS pass the reference object from the previous call.
		this.reference = reference;
	}

	// EXAMPLE!! METHOD WILL NOT WORK AS IS!
	// You must find the actual field and define it in the Hooks file.
	public int getLoginState() {

		// getField fetches the realtime object you want.
		// ALWAYS pass the reference forward.
		return (int) getField(loginState).getValue(reference);
	}
}
