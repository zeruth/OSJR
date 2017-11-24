package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class CombatInfo2 extends GameClass{
	
	public final String COMBAT_INFO_2_HEALTH_SCALE = "CombatInfo2_HealthScale";

	public CombatInfo2() {
		super("is");
		String combatInfo2 = "is";
		this.fields.put("CombatInfo2_HealthScale", new GameField("y", combatInfo2, -790609031));
	}

	public CombatInfo2(Object reference) {
		super("is");
		String combatInfo2 = "is";
		this.reference = reference;
		this.fields.put("CombatInfo2_HealthScale", new GameField("y", combatInfo2, -790609031));	
	}
	
	public Object getHealthScale() {
		System.out.println("Scale " + fields.get(COMBAT_INFO_2_HEALTH_SCALE).getValue(reference));
		return fields.get(COMBAT_INFO_2_HEALTH_SCALE).getValue(reference);
	}
}
