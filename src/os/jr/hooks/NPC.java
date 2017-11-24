package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class NPC extends GameClass{

	public NPC() {
		super("cj");
		String npc = "cj";
		this.fields.put("NPC_Definition", new GameField("d", npc));
	}

}
