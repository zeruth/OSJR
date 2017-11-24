package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class CombatInfoList extends GameClass{

	public CombatInfoList() {
		super("gl");
		String combatInfoList = "gl";
		this.fields.put("CombatInfoList_Head", new GameField("d", combatInfoList));
		this.fields.put("CombatInfoList_Current", new GameField("x", combatInfoList));
	}

}
