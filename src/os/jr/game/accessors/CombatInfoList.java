package os.jr.game.accessors;

import os.jr.hooks.HookLoader;
import os.jr.hooks.model.RSField;

public class CombatInfoList extends Actor{

	public CombatInfoList(Object actor, Client client) {
		this.obj = actor;
		this.client = client;
		this.hash = System.identityHashCode(this);
	}
	
	public Object getHead() {
		RSField f = HookLoader.classStorage.get("CombatInfoList").getField("CombatInfoList_Head");
		Object o = f.getValue(obj);
		return o;
	}
}
