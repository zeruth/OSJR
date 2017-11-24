package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class PlayerDefinition extends GameClass{

	public PlayerDefinition() {
		super("hy");
		String playerDefinition = "hy";
		this.fields.put("PlayerDefinition_ID", new GameField("z", playerDefinition, 432869533));
		this.fields.put("PlayerDefinition_IsFemale", new GameField("k", playerDefinition));
		this.fields.put("PlayerDefinition_AnimatedModelID", new GameField("v", playerDefinition, 67463743691277787L));
		this.fields.put("PlayerDefinition_ModelID", new GameField("m", playerDefinition, -3780734730102732469L));
		this.fields.put("PlayerDefinition_Equipment", new GameField("d", playerDefinition));
	}

}
