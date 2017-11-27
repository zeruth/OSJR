package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class CombatInfo1 extends GameClass{
	
	public final String COMBAT_INFO_1_HEALTH = "CombatInfo1_Health";

	public CombatInfo1() {
		super("cd");
		String combatInfo1 = "cd";
		this.fields.put("CombatInfo1_Health", new GameField("k", combatInfo1, 1138941551));
		this.fields.put("CombatInfo1_HealthRatio", new GameField("x", combatInfo1, -890855621));
	}
	

}
