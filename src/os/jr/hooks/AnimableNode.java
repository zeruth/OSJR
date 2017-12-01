package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class AnimableNode extends GameClass {

	public static final String animableNode = "cn";
	public static final String field_ID = "a";
	public static final String field_Animation = "t";
	public static final String field_Flags = "w";
	public static final String field_Orientation = "e";
	public static final String field_Plane = "k";
	public static final String field_X = "u";
	public static final String field_Y = "z";

	public AnimableNode() {
		super(animableNode);
		this.fields.put("AnimableNode_ID", new GameField(field_ID, animableNode));
		this.fields.put("AnimableNode_Animation", new GameField(field_Animation, animableNode));
		this.fields.put("AnimableNode_Flags", new GameField(field_Flags, animableNode));
		this.fields.put("AnimableNode_Orientation", new GameField(field_Orientation, animableNode));
		this.fields.put("AnimableNode_Plane", new GameField(field_Plane, animableNode));
		this.fields.put("AnimableNode_X", new GameField(field_X, animableNode));
		this.fields.put("AnimableNode_Y", new GameField(field_Y, animableNode));
	}

}
