package os.jr.hooks;

import os.jr.hooks.model.GameField;

public class Actor extends Renderable{
	
	public static final String x = "x";
	public static final String y = "y";
	public static final String angle = "angle";
	public static final String idlePoseAnimation = "idlePoseAnimation";
	public static final String overhead = "overhead";
	public static final String inSequence = "inSequence";
	public static final String overheadTextCyclesRemaining = "overheadTextCyclesRemaining";
	public static final String hitSplatTypes = "hitSplatTypes";
	public static final String hitSplatCycles = "hitSplatCycles";
	public static final String combatInfoList = "combatInfoList";
	public static final String interacting = "interacting";
	public static final String poseAnimation = "poseAnimation";
	public static final String poseFrame = "poseFrame";
	public static final String animation = "animation";
	public static final String actionFrame = "actionFrame";
	public static final String actionAnimationDisable = "actionAnimationDisable";
	public static final String graphic = "graphic";
	public static final String graphicsDelay = "graphicsDelay";
	public static final String npcCycle = "npcCycle";
	public static final String orientation = "orientation";
	public static final String queueSize = "queueSize";
	public static final String pathX = "pathX";
	public static final String pathY = "pathY";
	public static final String pathTraversed = "pathTraversed";
	public static final String hasConfig = "hasConfig";

	public Actor() {
		super(Hooks.classNames.get("Actor"));
	}
	
	public Actor(String className) {
		super(className);
	}
	
	public int getX() {
		return (int) Hooks.selector.actor.fields.get(x).getValue(reference);
	}
	
	public int getY() {
		return (int) Hooks.selector.actor.fields.get(y).getValue(reference);
	}
	
	public int getAngle() {
		return (int) Hooks.selector.actor.fields.get(angle).getValue(reference);
	}
	
	public int getIdlePoseAnimation() {
		return (int) Hooks.selector.actor.fields.get(idlePoseAnimation).getValue(reference);
	}
	
	public String getOverhead() {
		return (String) Hooks.selector.actor.fields.get(overhead).getValue(reference);
	}
	
	public boolean getInSequence() {
		return (boolean) Hooks.selector.actor.fields.get(inSequence).getValue(reference);
	}
	
	public int getOverheadTextCyclesRemaining() {
		return (int) Hooks.selector.actor.fields.get(overheadTextCyclesRemaining).getValue(reference);
	}
	
	public int[] getHitSplatTypes() {
		return (int[]) Hooks.selector.actor.fields.get(hitSplatTypes).getValue(reference);
	}
	
	public int[] getHitSplatCycles() {
		return (int[]) Hooks.selector.actor.fields.get(hitSplatCycles).getValue(reference);
	}
	
	public CombatInfoList getCombatInfoList() {
		return new CombatInfoList(Hooks.selector.actor.fields.get(combatInfoList).getValue(reference));
	}
	
	public int getInteracting() {
		return (int) Hooks.selector.actor.fields.get(interacting).getValue(reference);
	}
	
	public int getPoseAnimation() {
		return (int) Hooks.selector.actor.fields.get(poseAnimation).getValue(reference);
	}
	
	public int getPoseFrame() {
		return (int) Hooks.selector.actor.fields.get(poseFrame).getValue(reference);
	}
	
	public int getAnimation() {
		return (int) Hooks.selector.actor.fields.get(animation).getValue(reference);
	}
	
	public int getActionFrame() {
		return (int) Hooks.selector.actor.fields.get(actionFrame).getValue(reference);
	}
	
	public int getActionAnimationDisable() {
		return (int) Hooks.selector.actor.fields.get(actionAnimationDisable).getValue(reference);
	}
	
	public int getGraphic() {
		return (int) Hooks.selector.actor.fields.get(graphic).getValue(reference);
	}
	
	public int getGraphicsDelay() {
		return (int) Hooks.selector.actor.fields.get(graphicsDelay).getValue(reference);
	}
	
	public int getNpcCycle() {
		return (int) Hooks.selector.actor.fields.get(npcCycle).getValue(reference);
	}
	
	public int getOrientation() {
		return (int) Hooks.selector.actor.fields.get(orientation).getValue(reference);
	}
	
	public int getQueueSize() {
		return (int) Hooks.selector.actor.fields.get(queueSize).getValue(reference);
	}
	
	public int[] getPathX() {
		return (int[]) Hooks.selector.actor.fields.get(pathX).getValue(reference);
	}
	
	public int[] getPathY() {
		return (int[]) Hooks.selector.actor.fields.get(pathY).getValue(reference);
	}
	
	public byte[] getPathTraversed() {
		return (byte[]) Hooks.selector.actor.fields.get(pathTraversed).getValue(reference);
	}
	
	public boolean hasConfig() {
		return (boolean) Hooks.selector.actor.fields.get(hasConfig).getValue(reference);
	}
}
