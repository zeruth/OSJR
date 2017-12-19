package os.jr.hooks;

import java.util.HashMap;

import os.jr.hooks.model.GameClass;

public class Client extends GameClass{
	
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
	
	public Client(Object reference) {
		super(Hooks.classNames.get("Client"));
		this.reference=reference;
	}
	
	public int getWidgetCount() {
		return (int) Hooks.selector.client.fields.get(widgetCount).getValue(reference);
	}
	
	public boolean isResized() {
		return (boolean) Hooks.selector.client.fields.get(isResized).getValue(reference);
	}
	
	public int getGameDrawingMode() {
		return (int) Hooks.selector.client.fields.get(gameDrawingMode).getValue(reference);
	}
	
	public HashTable getWidgetFlags() {
		return new HashTable(Hooks.selector.client.fields.get(widgetFlags).getValue(reference));
	}
	
	public int[] getWidgetPositionX() {
		return (int[]) Hooks.selector.client.fields.get(widgetPositionX).getValue(reference);
	}
	
	public int[] getWidgetBoundsWidth() {
		return (int[]) Hooks.selector.client.fields.get(widgetBoundsWidth).getValue(reference);
	}
	
	public int[] getWidgetPositionY() {
		return (int[]) Hooks.selector.client.fields.get(widgetPositionY).getValue(reference);
	}
	
	public int[] getWidgetBoundsHeight() {
		return (int[]) Hooks.selector.client.fields.get(widgetBoundsHeight).getValue(reference);
	}
	
	public int getCycleCounter() {
		return (int) Hooks.selector.client.fields.get(cycleCntr).getValue(reference);
	}
	
	public String getClanChatOwner() {
		return (String) Hooks.selector.client.fields.get(clanChatOwner).getValue(reference);
	}
	
	public String getClanChatName() {
		return (String) Hooks.selector.client.fields.get(clanChatName).getValue(reference);
	}
	
	public int getMouseWheelRotation() {
		return (int) Hooks.selector.client.fields.get(mouseWheelRotation).getValue(reference);
	}
	
	public int getDestinationX() {
		return (int) Hooks.selector.client.fields.get(destinationX).getValue(reference);
	}
	
	public int getDestinationY() {
		return (int) Hooks.selector.client.fields.get(destinationY).getValue(reference);
	}
	
	public SoundEffect[] getAudioEffects() {
		Object[] os = (Object[]) Hooks.selector.client.fields.get(audioEffects).getValue(reference);
		SoundEffect[] audioEffects = new SoundEffect[os.length];
		int count = 0;
		for (Object o : os) {
			audioEffects[count] = new SoundEffect(o);
			count++;
		}
		return audioEffects;
	}
	
	public int[] getInterfaceItemTriggers() {
		return (int[]) Hooks.selector.client.fields.get(interfaceItemTriggers).getValue(reference);
	}
	
	public int getIgnoreCount() {
		return (int) Hooks.selector.client.fields.get(ignoreCount).getValue(reference);
	}
	
	public Ignore[] getIgnores() {
		Object[] os = (Object[]) Hooks.selector.client.fields.get(ignores).getValue(reference);
		Ignore[] ignores = new Ignore[os.length];
		int count = 0;
		for (Object o : os) {
			ignores[count] = new Ignore(o);
			count++;
		}
		return ignores;
	}
	
	public int getFriendCount() {
		return (int) Hooks.selector.client.fields.get(friendCount).getValue(reference);
	}
	
	public SpritePixels[] getMapIcons() {
		Object[] os = (Object[]) Hooks.selector.client.fields.get(mapIcons).getValue(reference);
		SpritePixels[] mapIcons = new SpritePixels[os.length];
		int count = 0;
		for (Object o : os) {
			mapIcons[count] = new SpritePixels(o);
			count++;
		}
		return mapIcons;
	}
	
	public Friend[] getFriends() {
		Object[] os = (Object[]) Hooks.selector.client.fields.get(friends).getValue(reference);
		Friend[] friends = new Friend[os.length];
		int count = 0;
		for (Object o : os) {
			friends[count] = new Friend(o);
			count++;
		}
		return friends;
	}
	
	public int getPublicChatMode() {
		return (int) Hooks.selector.client.fields.get(publicChatMode).getValue(reference);
	}
	
	public int getViewportXOffset() {
		return (int) Hooks.selector.client.fields.get(Viewport_xOffset).getValue(reference);
	}
	
	public int getViewportYOffset() {
		return (int) Hooks.selector.client.fields.get(Viewport_yOffset).getValue(reference);
	}
	
	public int getViewportHeight() {
		return (int) Hooks.selector.client.fields.get(viewportHeight).getValue(reference);
	}
	
	public int getViewportWidth() {
		return (int) Hooks.selector.client.fields.get(viewportWidth).getValue(reference);
	}
	
	public int getScale() {
		return (int) Hooks.selector.client.fields.get(scale).getValue(reference);
	}
	
	public GrandExchangeOffer[] getGrandExchangeOffers() {
		Object[] os = (Object[]) Hooks.selector.client.fields.get(friends).getValue(reference);
		GrandExchangeOffer[] grandExchangeOffers = new GrandExchangeOffer[os.length];
		int count = 0;
		for (Object o : os) {
			grandExchangeOffers[count] = new GrandExchangeOffer(o);
			count++;
		}
		return grandExchangeOffers;
	}
	
	public int getChatCycle() {
		return (int) Hooks.selector.client.fields.get(chatCycle).getValue(reference);
	}
	
	public CollisionData[] getCollisionMaps() {
		Object[] os = (Object[]) Hooks.selector.client.fields.get(friends).getValue(reference);
		CollisionData[] collisionMaps = new CollisionData[os.length];
		int count = 0;
		for (Object o : os) {
			collisionMaps[count] = new CollisionData(o);
			count++;
		}
		return collisionMaps;
	}
	
	public int getWorld() {
		return (int) Hooks.selector.client.fields.get(world).getValue(reference);
	}
	
	public int getFlags() {
		return (int) Hooks.selector.client.fields.get(flags).getValue(reference);
	}
	
	public int getSocketType() {
		return (int) Hooks.selector.client.fields.get(socketType).getValue(reference);
	}
	
	public boolean isMembers() {
		return (boolean) Hooks.selector.client.fields.get(isMembers).getValue(reference);
	}
	
	public boolean lowMemory() {
		return (boolean) Hooks.selector.client.fields.get(lowMemory).getValue(reference);
	}
	
	public int getLanguageID() {
		return (int) Hooks.selector.client.fields.get(languageId).getValue(reference);
	}
	
	public int getGameState() {
		return (int) Hooks.selector.client.fields.get(gameState).getValue(reference);
	}
	
	public int getGameCycle() {
		return (int) Hooks.selector.client.fields.get(gameCycle).getValue(reference);
	}
	
	public int getMouseLastPressedTimeMillis() {
		return (int) Hooks.selector.client.fields.get(mouseLastPressedTimeMillis).getValue(reference);
	}
	
	public boolean displayFps() {
		return (boolean) Hooks.selector.client.fields.get(displayFps).getValue(reference);
	}
	
	public int getHintArrowTargetType() {
		return (int) Hooks.selector.client.fields.get(hintArrowTargetType).getValue(reference);
	}
	
	public int getHintArrowNpcTargetIdx() {
		return (int) Hooks.selector.client.fields.get(hintArrowNpcTargetIdx).getValue(reference);
	}
	
	public int getHintArrowPlayerTargetIdx() {
		return (int) Hooks.selector.client.fields.get(hintArrowPlayerTargetIdx).getValue(reference);
	}
	
	public int getHintArrowX() {
		return (int) Hooks.selector.client.fields.get(hintArrowX).getValue(reference);
	}
	
	public int getHintArrowY() {
		return (int) Hooks.selector.client.fields.get(hintArrowY).getValue(reference);
	}
	
	public int getHintArrowType() {
		return (int) Hooks.selector.client.fields.get(hintArrowType).getValue(reference);
	}
	
	public int getHintArrowOffsetX() {
		return (int) Hooks.selector.client.fields.get(hintArrowOffsetX).getValue(reference);
	}
	
	public int getHintArrowOffsetY() {
		return (int) Hooks.selector.client.fields.get(hintArrowOffsetY).getValue(reference);
	}
	
	public AttackOption getPlayerAttackOption() {
		return new AttackOption(Hooks.selector.client.fields.get(playerAttackOption).getValue(reference));
	}
	
	public AttackOption getNPCAttackOption() {
		return new AttackOption(Hooks.selector.client.fields.get(npcAttackOption).getValue(reference));
	}
	
	public int getLoadingStage() {
		return (int) Hooks.selector.client.fields.get(loadingStage).getValue(reference);
	}
	
	public int getjs5State() {
		return (int) Hooks.selector.client.fields.get(js5State).getValue(reference);
	}
	
	public int getLoginState() {
		return (int) Hooks.selector.client.fields.get(loginState).getValue(reference);
	}
	
	public NPC[] getCachedNPCs() {
		Object[] os = (Object[]) Hooks.selector.client.fields.get(friends).getValue(reference);
		NPC[] cachedNPCs = new NPC[os.length];
		int count = 0;
		for (Object o : os) {
			cachedNPCs[count] = new NPC(o);
			count++;
		}
		return cachedNPCs;
	}
	
	public int getNPCIndexesCount() {
		return (int) Hooks.selector.client.fields.get(npcIndexesCount).getValue(reference);
	}
	
	public int[] getNPCIndices() {
		return (int[]) Hooks.selector.client.fields.get(npcIndices).getValue(reference);
	}
	
	public int getPendingNPCFlagsIndices() {
		return (int) Hooks.selector.client.fields.get(pendingNpcFlagsIndices).getValue(reference);
	}
	
	public boolean socketError() {
		return (boolean) Hooks.selector.client.fields.get(socketError).getValue(reference);
	}
	
	public HashMap getFontsMap() {
		return (HashMap) Hooks.selector.client.fields.get(fontsMap).getValue(reference);
	}
	
	public int getBaseY() {
		return (int) Hooks.selector.client.fields.get(baseY).getValue(reference);
	}
	
	public int getBaseX() {
		return (int) Hooks.selector.client.fields.get(baseX).getValue(reference);
	}
	
	public boolean isDynamicRegion() {
		return (boolean) Hooks.selector.client.fields.get(isDynamicRegion).getValue(reference);
	}
	
	public int getMapAngle() {
		return (int) Hooks.selector.client.fields.get(mapAngle).getValue(reference);
	}
	
	public int getScreenY() {
		return (int) Hooks.selector.client.fields.get(screenY).getValue(reference);
	}
	
	public int getScreenX() {
		return (int) Hooks.selector.client.fields.get(screenX).getValue(reference);
	}
	
	public int getCursorState() {
		return (int) Hooks.selector.client.fields.get(cursorState).getValue(reference);
	}
	
	public int getMouseCrosshair() {
		return (int) Hooks.selector.client.fields.get(mouseCrosshair).getValue(reference);
	}
	
	public Player[] getCachedPlayers() {
		Object[] os = (Object[]) Hooks.selector.client.fields.get(friends).getValue(reference);
		Player[] cachedPlayers = new Player[os.length];
		int count = 0;
		for (Object o : os) {
			cachedPlayers[count] = new Player(o);
			count++;
		}
		return cachedPlayers;
	}
	
	public int getLocalInteractingIndex() {
		return (int) Hooks.selector.client.fields.get(localInteractingIndex).getValue(reference);
	}
	
	public int[] getPlayerMenuTypes() {
		return (int[]) Hooks.selector.client.fields.get(playerMenuTypes).getValue(reference);
	}
	
	public int[] getPlayerOptions() {
		return (int[]) Hooks.selector.client.fields.get(playerOptions).getValue(reference);
	}
	
	public String getLastSelectedItemName() {
		return (String) Hooks.selector.client.fields.get(lastSelectedItemName).getValue(reference);
	}
	
	public boolean[] getPlayerOptionsPriorities() {
		return (boolean[]) Hooks.selector.client.fields.get(playerOptionsPriorities).getValue(reference);
	}
	
	public Deque getGroundItemDeque() {
		return new Deque((Object[][][])Hooks.selector.client.fields.get(groundItemDeque).getValue(reference));
	}
	
	public Deque getPendingSpawns() {
		return new Deque(Hooks.selector.client.fields.get(pendingSpawns).getValue(reference));
	}
	
	public Deque getProjectiles() {
		return new Deque(Hooks.selector.client.fields.get(projectiles).getValue(reference));
	}
	
	public Deque getGraphicsObjectDeque() {
		return new Deque(Hooks.selector.client.fields.get(graphicsObjectDeque).getValue(reference));
	}
	
	public int[] getModifiedSkillLevels() {
		return (int[]) Hooks.selector.client.fields.get(boostedSkillLevels).getValue(reference);
	}
	
	public int[] getRealSkillLevels() {
		return (int[]) Hooks.selector.client.fields.get(realSkillLevels).getValue(reference);
	}
	
	public int[] getSkillExperiences() {
		return (int[]) Hooks.selector.client.fields.get(skillExperiences).getValue(reference);
	}
	
	public boolean isMenuOpen() {
		return (boolean) Hooks.selector.client.fields.get(isMenuOpen).getValue(reference);
	}
	
	public int getMenuOptionCount() {
		return (int) Hooks.selector.client.fields.get(menuOptionCount).getValue(reference);
	}
	
	public int[] getMenuActionParams0() {
		return (int[]) Hooks.selector.client.fields.get(menuActionParams0).getValue(reference);
	}
	
	public int[] getMenuActionParams1() {
		return (int[]) Hooks.selector.client.fields.get(menuActionParams1).getValue(reference);
	}
	
	public int[] getMenuTypes() {
		return (int[]) Hooks.selector.client.fields.get(menuTypes).getValue(reference);
	}
	
	public int[] getMenuIdentifiers() {
		return (int[]) Hooks.selector.client.fields.get(menuIdentifiers).getValue(reference);
	}
	
	public String[] getMenuOptions() {
		return (String[]) Hooks.selector.client.fields.get(menuOptions).getValue(reference);
	}
	
	public String[] getMenuTargets() {
		return (String[]) Hooks.selector.client.fields.get(menuTargets).getValue(reference);
	}
	
	public boolean[] getMenuBooleanArray() {
		return (boolean[]) Hooks.selector.client.fields.get(menuBooleanArray).getValue(reference);
	}
	
	public int getItemSelectionState() {
		return (int) Hooks.selector.client.fields.get(itemSelectionState).getValue(reference);
	}
	
	public boolean spellSelected() {
		return (boolean) Hooks.selector.client.fields.get(spellSelected).getValue(reference);
	}
	
	public int getWidgetRoot() {
		return (int) Hooks.selector.client.fields.get(widgetRoot).getValue(reference);
	}
	
	public HashTable getComponentTable() {
		return new HashTable(Hooks.selector.client.fields.get(componentTable).getValue(reference));
	}
	
	public int getEnergy() {
		return (int) Hooks.selector.client.fields.get(energy).getValue(reference);
	}
	
	public int getWeight() {
		return (int) Hooks.selector.client.fields.get(weight).getValue(reference);
	}
	
	public int getRights() {
		return (int) Hooks.selector.client.fields.get(rights).getValue(reference);
	}
	
	public boolean numberMenuOptions() {
		return (boolean) Hooks.selector.client.fields.get(numberMenuOptions).getValue(reference);
	}

	public boolean isLoggedOn() {
		return (getLoginState()==10);
	}
	
	public Player getLocalPlayer() {
		return Hooks.selector.urlRequest.getLocalPlayer();
	}
}
