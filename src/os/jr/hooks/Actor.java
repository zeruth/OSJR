package os.jr.hooks;

import os.jr.boot.Boot;
import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Actor extends GameClass {
	
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
	
	public CombatInfoList getCombatInfoList(Object reference) throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		Actor actor = Hooks.selector.actor;
		combatInfoList = actor.getFieldValue(actor.ACTOR_COMBAT_INFO_LIST, reference);
		return new CombatInfoList(combatInfoList);
	}

}
