package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class CombatInfo2 extends GameClass {

	public static final String combatInfo2 = "ir";
	public static final String field_HealthScale = "y";

	public static final int field_HealthScale_multiplier = -500589715;

	public final String COMBAT_INFO_2_HEALTH_SCALE = "CombatInfo2_HealthScale";

	public CombatInfo2() {
		super(combatInfo2);
		this.fields.put("CombatInfo2_HealthScale",
				new GameField(field_HealthScale, combatInfo2, field_HealthScale_multiplier));
	}

	public CombatInfo2(Object reference) {
		super(combatInfo2);
		this.reference = reference;
		this.fields.put("CombatInfo2_HealthScale",
				new GameField(field_HealthScale, combatInfo2, field_HealthScale_multiplier));
	}

	public int getHealthScale() {
		return (int) fields.get(COMBAT_INFO_2_HEALTH_SCALE).getValue(reference);
	}
}
