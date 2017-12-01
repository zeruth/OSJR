package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class CombatInfoHolder extends GameClass {

	public static final String combatInfoHolder = "cq";
	public static final String field_CombatInfoList = "k";
	public static final String field_CombatInfo2 = "e";

	public final String COMBAT_INFO_HOLDER_COMBAT_INFO_LIST = "CombatInfoHolder_CombatInfoList";
	public final String COMBAT_INFO_HOLDER_COMBAT_INFO_2 = "CombatInfoHolder_CombatInfo2";

	public CombatInfoHolder() {
		super(combatInfoHolder);
		this.fields.put("CombatInfoHolder_CombatInfoList", new GameField(field_CombatInfoList, combatInfoHolder));
		this.fields.put("CombatInfoHolder_CombatInfo2", new GameField(field_CombatInfo2, combatInfoHolder));
	}

	public CombatInfoHolder(Object reference) {
		super(combatInfoHolder);
		this.reference = reference;
		this.fields.put("CombatInfoHolder_CombatInfoList", new GameField(field_CombatInfoList, combatInfoHolder));
		this.fields.put("CombatInfoHolder_CombatInfo2", new GameField(field_CombatInfo2, combatInfoHolder));
	}

	public CombatInfoList getCombatInfoList() {
		return new CombatInfoList(fields.get(COMBAT_INFO_HOLDER_COMBAT_INFO_LIST).getValue(reference));
	}

}
