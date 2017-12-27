package os.jr.hooks;

public class Actor extends Renderable {

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

	public Actor(Object reference) {
		super(Hooks.classNames.get("Actor"));
		this.reference = reference;
	}

	public int getActionAnimationDisable() {
		return (int) getField(actionAnimationDisable).getValue(reference);
	}

	public int getActionFrame() {
		return (int) getField(actionFrame).getValue(reference);
	}

	public int getAngle() {
		return (int) getField(angle).getValue(reference);
	}

	public int getAnimation() {
		return (int) getField(animation).getValue(reference);
	}

	public CombatInfoList getCombatInfoList() {
		return new CombatInfoList(getField(combatInfoList).getValue(reference));
	}

	public int getGraphic() {
		return (int) getField(graphic).getValue(reference);
	}

	public int getGraphicsDelay() {
		return (int) getField(graphicsDelay).getValue(reference);
	}

	public int[] getHitSplatCycles() {
		return (int[]) getField(hitSplatCycles).getValue(reference);
	}

	public int[] getHitSplatTypes() {
		return (int[]) getField(hitSplatTypes).getValue(reference);
	}

	public int getIdlePoseAnimation() {
		return (int) getField(idlePoseAnimation).getValue(reference);
	}

	public boolean getInSequence() {
		return (boolean) getField(inSequence).getValue(reference);
	}

	public int getInteracting() {
		return (int) getField(interacting).getValue(reference);
	}

	public int getNpcCycle() {
		return (int) getField(npcCycle).getValue(reference);
	}

	public int getOrientation() {
		return (int) getField(orientation).getValue(reference);
	}

	public String getOverhead() {
		return (String) getField(overhead).getValue(reference);
	}

	public int getOverheadTextCyclesRemaining() {
		return (int) getField(overheadTextCyclesRemaining).getValue(reference);
	}

	public byte[] getPathTraversed() {
		return (byte[]) getField(pathTraversed).getValue(reference);
	}

	public int[] getPathX() {
		return (int[]) getField(pathX).getValue(reference);
	}

	public int[] getPathY() {
		return (int[]) getField(pathY).getValue(reference);
	}

	public int getPoseAnimation() {
		return (int) getField(poseAnimation).getValue(reference);
	}

	public int getPoseFrame() {
		return (int) getField(poseFrame).getValue(reference);
	}

	public int getQueueSize() {
		return (int) getField(queueSize).getValue(reference);
	}

	public int getX() {
		return (int) getField(x).getValue(reference);
	}

	public int getY() {
		return (int) getField(y).getValue(reference);
	}

	public boolean hasConfig() {
		return (boolean) getField(hasConfig).getValue(reference);
	}
}
