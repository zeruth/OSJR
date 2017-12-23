package os.jr.hooks;

public class CombatInfo1 extends Node {
	
	public static final String cycle = "cycle";
	public static final String healthRatio = "healthRatio";
	public static final String health = "health";
	public static final String int2 = "int2";

	public CombatInfo1(Object reference) {
		super(Hooks.classNames.get("CombatInfo1"));
		this.reference = reference;
	}
	
	public int getCycle() {
		return (int) getField(cycle).getValue(reference);
	}
	
	public int getHealthRatio() {
		return (int) getField(healthRatio).getValue(reference);
	}
	
	public int getHealth() {
		return (int) getField(health).getValue(reference);
	}
	
	public int getInt2() {
		return (int) getField(int2).getValue(reference);
	}

}
