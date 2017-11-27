package os.jr.hooks;

import os.jr.boot.Boot;
import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;
import os.jr.utils.Tile;

public class Actor extends GameClass {
	
	public final String ACTOR_ANIMATION = "Actor_Animation";
	public final String ACTOR_ANIMATION_DELAY = "Actor_AnimationDelay";
	public final String ACTOR_SPOKEN_TEXT = "Actor_SpokenText";
	public final String ACTOR_COMBAT_INFO_LIST = "Actor_CombatInfoList";
	public final String ACTOR_WORLD_X = "Actor_WorldX";
	public final String ACTOR_WORLD_Y = "Actor_WorldY";
	public final String ACTOR_QUEUE_SIZE = "Actor_QueueSize";
	public Object combatInfoList;

	public Actor() {
		super("by");
		String actor = "by";
		this.fields.put("Actor_Animation", new GameField("bn", actor, 1408809497));
		this.fields.put("Actor_AnimationDelay", new GameField("bm", actor, -261419251));
		this.fields.put("Actor_SpokenText", new GameField("ad", actor));
		this.fields.put("Actor_WorldX", new GameField("ak", actor, -668311719));
		this.fields.put("Actor_WorldY", new GameField("aa", actor, -639886065));
		this.fields.put("Actor_QueueX", new GameField("cy", actor));
		this.fields.put("Actor_QueueY", new GameField("cb", actor));
		this.fields.put("Actor_QueueTraversed", new GameField("cj", actor));
		this.fields.put("Actor_QueueSize", new GameField("cs", actor, 2109489259));
		this.fields.put("Actor_IsAnimating", new GameField("ai", actor));
		//this.fields.put("Actor_CombatCycle", new GameField("z", actor)); N/A
		this.fields.put("Actor_InteractingIndex", new GameField("bo", actor, -1519201681));
		this.fields.put("Actor_Orientation", new GameField("cw", actor, -781830063));
		this.fields.put("Actor_CombatInfoList", new GameField("bq", actor));
		this.fields.put("Actor_Height", new GameField("cd", actor, 2142258075));
	}
	
	public Actor(Object reference) {
		super("by");
		String actor = "by";
		this.reference = reference;
		this.fields.put("Actor_Animation", new GameField("bn", actor, 1408809497));
		this.fields.put("Actor_AnimationDelay", new GameField("bm", actor, -261419251));
		this.fields.put("Actor_SpokenText", new GameField("ad", actor));
		this.fields.put("Actor_WorldX", new GameField("ak", actor, -668311719));
		this.fields.put("Actor_WorldY", new GameField("aa", actor, -639886065));
		this.fields.put("Actor_QueueX", new GameField("cy", actor));
		this.fields.put("Actor_QueueY", new GameField("cb", actor));
		this.fields.put("Actor_QueueTraversed", new GameField("cj", actor));
		this.fields.put("Actor_QueueSize", new GameField("cs", actor, 2109489259));
		this.fields.put("Actor_IsAnimating", new GameField("ai", actor));
		//this.fields.put("Actor_CombatCycle", new GameField("z", actor)); N/A
		this.fields.put("Actor_InteractingIndex", new GameField("bo", actor, -1519201681));
		this.fields.put("Actor_Orientation", new GameField("cw", actor, -781830063));
		this.fields.put("Actor_CombatInfoList", new GameField("bq", actor));
		this.fields.put("Actor_Height", new GameField("cd", actor, 2142258075));	}

	public int getAnimation() {
		return (int)fields.get(ACTOR_ANIMATION).getValue(reference);
	}
	
	public int getAnimationDelay() {
		return (int)fields.get(ACTOR_ANIMATION_DELAY).getValue(reference);
	}
	
	public String getSpokenText() {
		return (String)fields.get(ACTOR_SPOKEN_TEXT).getValue(reference);
	}
	
	public Tile getTile() {
		Client c = Hooks.selector.client;
		int x = c.getBaseX() + (int)fields.get(ACTOR_WORLD_X).getValue(reference);
		int y = c.getBaseY() + (int)fields.get(ACTOR_WORLD_Y).getValue(reference);
		return new Tile(x, y);
	}
	
	public int getQueueSize() {
		return (int)fields.get(ACTOR_QUEUE_SIZE).getValue(reference);
	}
	
	public CombatInfoList getCombatInfoList() {
		Actor actor = Hooks.selector.actor;
		combatInfoList = actor.getFieldValue(actor.ACTOR_COMBAT_INFO_LIST, reference);
		return new CombatInfoList(combatInfoList);
	}
	
	public CombatInfoHolder getCombatInfoHolder() {
		return new CombatInfoHolder(getCombatInfoList().getHead().getNext());
	}
	
	
	public CombatInfoList getCombatInfoHolderList() {
		return new CombatInfoList(getCombatInfoHolder().getCombatInfoList().getHead().getNext());
	}

	
	public int getMaxHealth() {
		int i = getCombatInfoList().getCombatInfo2().getHealthScale();
		return i;
	}
	
	public double getHealthPercentage() {
		int current = getCurrentHealth();
		int max = getMaxHealth();
		double k = (current * 100.0f) / max;
		return k;
	}

	
	public int getCurrentHealth() {
		CombatInfo1 info1 = Hooks.selector.combatInfo1;
		int health = (int)info1.fields.get(info1.COMBAT_INFO_1_HEALTH).getValue(getCombatInfoHolderList().reference);
		return health-1;
	}

}
