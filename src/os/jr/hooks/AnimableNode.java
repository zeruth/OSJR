package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class AnimableNode extends GameClass{

	public AnimableNode() {
		super("cx");
		String animableNode = "cx";
		this.fields.put("AnimableNode_ID", new GameField("d", animableNode));
		this.fields.put("AnimableNode_Animation", new GameField("b", animableNode));
		this.fields.put("AnimableNode_Flags", new GameField("x", animableNode));
		this.fields.put("AnimableNode_Orientation", new GameField("k", animableNode));
		this.fields.put("AnimableNode_Plane", new GameField("z", animableNode));
		this.fields.put("AnimableNode_X", new GameField("v", animableNode));
		this.fields.put("AnimableNode_Y", new GameField("m", animableNode));
	}

}
