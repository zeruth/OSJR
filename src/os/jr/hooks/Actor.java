package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;
import os.jr.utils.Tile;

public class Actor extends Renderable {

	public static final String actor = "br";
	public static final String field_Animation = "bw";
	public static final String field_AnimationDelay = "cb";
	public static final String field_SpokenText = "ai";
	public static final String field_HitDamages = "aj";
	public static final String field_HitTypes = "ao";
	public static final String field_HitCycle = "ar";
	public static final String field_QueueX = "cj";
	public static final String field_QueueY = "cq";
	public static final String field_QueueTraversed = "ci";
	public static final String field_QueueSize = "cv";
	public static final String field_WorldX = "ad";
	public static final String field_WorldY = "ag";
	public static final String field_IsAnimating = "ah";
	public static final String field_CombatCycle = null;
	public static final String field_InteractingIndex = "bp";
	public static final String field_Orientation = "cp";
	public static final String field_CombatInfoList = "bc";
	public static final String field_Height = "ch";

	public static final int field_Animation_multiplier = 1823864565;
	public static final int field_AnimationDelay_multiplier = 1585038085;
	public static final int field_QueueSize_multiplier = -979915637;
	public static final int field_WorldX_multiplier = 1951012149;
	public static final int field_WorldY_multiplier = -959431109;
	public static final int field_InteractingIndex_multiplier = -156297857;
	public static final int field_Orientation_multiplier = -878372439;
	public static final int field_Height_multiplier = -1048565403;

	public final String ACTOR_ANIMATION = "Actor_Animation";
	public final String ACTOR_ANIMATION_DELAY = "Actor_AnimationDelay";
	public final String ACTOR_SPOKEN_TEXT = "Actor_SpokenText";
	public final String ACTOR_COMBAT_INFO_LIST = "Actor_CombatInfoList";
	public final String ACTOR_WORLD_X = "Actor_WorldX";
	public final String ACTOR_WORLD_Y = "Actor_WorldY";
	public final String ACTOR_QUEUE_SIZE = "Actor_QueueSize";
	public Object combatInfoList;

	public Actor() {
		super(actor);
		this.fields.put("Actor_Animation", new GameField(field_Animation, actor, field_Animation_multiplier));
		this.fields.put("Actor_AnimationDelay",
				new GameField(field_AnimationDelay, actor, field_AnimationDelay_multiplier));
		this.fields.put("Actor_SpokenText", new GameField(field_SpokenText, actor));
		this.fields.put("Actor_HitDamages", new GameField(field_HitDamages, actor));
		this.fields.put("Actor_HitTypes", new GameField(field_HitTypes, actor));
		this.fields.put("Actor_HitCycle", new GameField(field_HitCycle, actor));
		this.fields.put("Actor_QueueX", new GameField(field_QueueX, actor));
		this.fields.put("Actor_QueueY", new GameField(field_QueueY, actor));
		this.fields.put("Actor_QueueTraversed", new GameField(field_QueueTraversed, actor));
		this.fields.put("Actor_QueueSize", new GameField(field_QueueSize, actor, field_QueueSize_multiplier));
		this.fields.put("Actor_WorldX", new GameField(field_WorldX, actor, field_WorldX_multiplier));
		this.fields.put("Actor_WorldY", new GameField(field_WorldY, actor, field_WorldY_multiplier));
		this.fields.put("Actor_IsAnimating", new GameField(field_IsAnimating, actor));
		// this.fields.put("Actor_CombatCycle", new GameField("z", actor)); N/A
		this.fields.put("Actor_InteractingIndex",
				new GameField(field_InteractingIndex, actor, field_InteractingIndex_multiplier));
		this.fields.put("Actor_Orientation", new GameField(field_Orientation, actor, field_Orientation_multiplier));
		this.fields.put("Actor_CombatInfoList", new GameField(field_CombatInfoList, actor));
		this.fields.put("Actor_Height", new GameField(field_Height, actor, field_Height_multiplier));
	}

	public Actor(Object reference) {
		super(actor);
		this.reference = reference;
		this.fields.put("Actor_Animation", new GameField(field_Animation, actor, field_Animation_multiplier));
		this.fields.put("Actor_AnimationDelay",
				new GameField(field_AnimationDelay, actor, field_AnimationDelay_multiplier));
		this.fields.put("Actor_SpokenText", new GameField(field_SpokenText, actor));
		this.fields.put("Actor_HitDamages", new GameField(field_HitDamages, actor));
		this.fields.put("Actor_HitTypes", new GameField(field_HitTypes, actor));
		this.fields.put("Actor_HitCycle", new GameField(field_HitCycle, actor));
		this.fields.put("Actor_QueueX", new GameField(field_QueueX, actor));
		this.fields.put("Actor_QueueY", new GameField(field_QueueY, actor));
		this.fields.put("Actor_QueueTraversed", new GameField(field_QueueTraversed, actor));
		this.fields.put("Actor_QueueSize", new GameField(field_QueueSize, actor, field_QueueSize_multiplier));
		this.fields.put("Actor_WorldX", new GameField(field_WorldX, actor, field_WorldX_multiplier));
		this.fields.put("Actor_WorldY", new GameField(field_WorldY, actor, field_WorldY_multiplier));
		this.fields.put("Actor_IsAnimating", new GameField(field_IsAnimating, actor));
		// this.fields.put("Actor_CombatCycle", new GameField("z", actor)); N/A
		this.fields.put("Actor_InteractingIndex",
				new GameField(field_InteractingIndex, actor, field_InteractingIndex_multiplier));
		this.fields.put("Actor_Orientation", new GameField(field_Orientation, actor, field_Orientation_multiplier));
		this.fields.put("Actor_CombatInfoList", new GameField(field_CombatInfoList, actor));
		this.fields.put("Actor_Height", new GameField(field_Height, actor, field_Height_multiplier));
	}

	public int getAnimation() {
		return (int) fields.get(ACTOR_ANIMATION).getValue(reference);
	}

	public int getAnimationDelay() {
		return (int) fields.get(ACTOR_ANIMATION_DELAY).getValue(reference);
	}

	public String getSpokenText() {
		return (String) fields.get(ACTOR_SPOKEN_TEXT).getValue(reference);
	}

	public Tile getTile() {
		Client c = Hooks.selector.client;
		int x = c.getBaseX() + (int) fields.get(ACTOR_WORLD_X).getValue(reference);
		int y = c.getBaseY() + (int) fields.get(ACTOR_WORLD_Y).getValue(reference);
		return new Tile(x, y);
	}

	public int getQueueSize() {
		return (int) fields.get(ACTOR_QUEUE_SIZE).getValue(reference);
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

	public int getHealthBarMax() {
		int i = getCombatInfoList().getCombatInfo2().getHealthScale();
		return i;
	}

	public double getHealthBarPercentage() {
		int current = getHealthBarCurrent();
		int max = getHealthBarMax();
		double k = (current * 100.0f) / max;
		return k;
	}

	public int getHealthBarCurrent() {
		CombatInfo1 info1 = Hooks.selector.combatInfo1;
		int health = (int) info1.fields.get(info1.COMBAT_INFO_1_HEALTH).getValue(getCombatInfoHolderList().reference);
		return health;
	}

}
