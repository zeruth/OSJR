package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class NPC extends GameClass {

	public static final String npc = "ci";
	public static final String field_Definition = "a";

	public NPC() {
		super(npc);
		this.fields.put("NPC_Definition", new GameField(field_Definition, npc));
	}

}
