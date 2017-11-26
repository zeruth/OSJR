package os.jr.hooks;

import os.jr.boot.Boot;
import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Actor extends GameClass {
	
	public final String ACTOR_ANIMATION = "Actor_Animation";
	public final String ACTOR_COMBAT_INFO_LIST = "Actor_CombatInfoList";
	public Object combatInfoList;

	public Actor() {
		super("by");
		String actor = "by";
		this.fields.put("Actor_Animation", new GameField("bn", actor, 1408809497));
		this.fields.put("Actor_AnimationDelay", new GameField("bm", actor, -261419251));
		this.fields.put("Actor_SpokenText", new GameField("ad", actor));
		this.fields.put("Actor_HitDamages", new GameField("av", actor));
		this.fields.put("Actor_HitTypes", new GameField("ab", actor));
		this.fields.put("Actor_HitCycle", new GameField("az", actor));
		this.fields.put("Actor_QueueX", new GameField("cy", actor));
		this.fields.put("Actor_QueueY", new GameField("cb", actor));
		this.fields.put("Actor_QueueTraversed", new GameField("cj", actor));
		this.fields.put("Actor_QueueSize", new GameField("cs", actor, 2109489259));
		this.fields.put("Actor_WorldX", new GameField("ak", actor, -668311719));
		this.fields.put("Actor_WorldY", new GameField("aa", actor, -639886065));
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
		this.fields.put("Actor_HitDamages", new GameField("av", actor));
		this.fields.put("Actor_HitTypes", new GameField("ab", actor));
		this.fields.put("Actor_HitCycle", new GameField("az", actor));
		this.fields.put("Actor_QueueX", new GameField("cy", actor));
		this.fields.put("Actor_QueueY", new GameField("cb", actor));
		this.fields.put("Actor_QueueTraversed", new GameField("cj", actor));
		this.fields.put("Actor_QueueSize", new GameField("cs", actor, 2109489259));
		this.fields.put("Actor_WorldX", new GameField("ak", actor, -668311719));
		this.fields.put("Actor_WorldY", new GameField("aa", actor, -639886065));
		this.fields.put("Actor_IsAnimating", new GameField("ai", actor));
		//this.fields.put("Actor_CombatCycle", new GameField("z", actor)); N/A
		this.fields.put("Actor_InteractingIndex", new GameField("bo", actor, -1519201681));
		this.fields.put("Actor_Orientation", new GameField("cw", actor, -781830063));
		this.fields.put("Actor_CombatInfoList", new GameField("bq", actor));
		this.fields.put("Actor_Height", new GameField("cd", actor, 2142258075));	}

	public CombatInfoList getCombatInfoList() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		Actor actor = Hooks.selector.actor;
		combatInfoList = actor.getFieldValue(actor.ACTOR_COMBAT_INFO_LIST, reference);
		return new CombatInfoList(combatInfoList);
	}
	
	public int getHealthScale() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		return (int)getCombatInfoList().getCombatInfo2().getHealthScale();
	}
	
	public int getAnimation() {
		return (int)fields.get(ACTOR_ANIMATION).getValue(reference);
	}
	
	public int getHealth() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		Object o = getCombatInfoList().getHead().getNext();
		CombatInfoHolder cih = Hooks.selector.combatInfoHolder;
		Object combatInfoList = cih.getFieldValue(cih.COMBAT_INFO_HOLDER_COMBAT_INFO_LIST, o);
		Node node = new Node(Hooks.selector.combatInfoList.getFieldValue(Hooks.selector.combatInfoList.COMBAT_INFO_LIST_HEAD, combatInfoList));
		node.getNext();
		return (int)node.getNext();
	}

}
