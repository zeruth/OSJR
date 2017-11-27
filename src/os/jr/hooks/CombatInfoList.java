package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class CombatInfoList extends GameClass{
	
	public final String COMBAT_INFO_LIST_HEAD = "CombatInfoList_Head";

	public CombatInfoList() {
		super("gl");
		String combatInfoList = "gl";
		this.fields.put("CombatInfoList_Head", new GameField("d", combatInfoList));
		this.fields.put("CombatInfoList_Current", new GameField("x", combatInfoList));
	}

	public CombatInfoList(Object reference) {
		super("gl");
		String combatInfoList = "gl";
		this.reference = reference;
		this.fields.put("CombatInfoList_Head", new GameField("d", combatInfoList));
		this.fields.put("CombatInfoList_Current", new GameField("x", combatInfoList));	}

	public Node getHead() {
		return new Node(fields.get(COMBAT_INFO_LIST_HEAD).getValue(reference));
	}
	
	public CombatInfo2 getCombatInfo2() {
		CombatInfoHolder h = Hooks.selector.combatInfoHolder;
		return new CombatInfo2(h.getFieldValue(h.COMBAT_INFO_HOLDER_COMBAT_INFO_2, getHead().getNext()));
	}
}
