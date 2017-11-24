package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class CombatInfoHolder extends GameClass{

	public CombatInfoHolder() {
		super("cb");
		String combatInfoHolder = "cb";
		this.fields.put("CombatInfoHolder_CombatInfoList", new GameField("z", combatInfoHolder));
		this.fields.put("CombatInfoHolder_CombatInfo2", new GameField("k", combatInfoHolder));
	}

}
