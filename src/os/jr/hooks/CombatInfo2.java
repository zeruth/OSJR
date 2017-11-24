package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class CombatInfo2 extends GameClass{

	public CombatInfo2() {
		super("is");
		String combatInfo2 = "is";
		this.fields.put("CombatInfo2_HealthScale", new GameField("y", combatInfo2, -790609031));
	}

}
