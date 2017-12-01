package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class CombatInfo1 extends GameClass {

	public static final String combatInfo1 = "ch";
	public static final String field_Health = "e";
	public static final String field_HealthRatio = "w";

	public static final int field_Health_multiplier = 664186193;
	public static final int field_HealthRatio_multiplier = 1616408329;

	public final String COMBAT_INFO_1_HEALTH = "CombatInfo1_Health";

	public CombatInfo1() {
		super(combatInfo1);
		this.fields.put("CombatInfo1_Health", new GameField(field_Health, combatInfo1, field_Health_multiplier));
		this.fields.put("CombatInfo1_HealthRatio",
				new GameField(field_HealthRatio, combatInfo1, field_HealthRatio_multiplier));
	}

}
