package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class NodeDeque extends GameClass {

	public static final String nodeDeque = "go";
	public static final String field_Head = "a";
	public static final String field_Current = "w";

	public NodeDeque() {
		super(nodeDeque);
		this.fields.put("NodeDeque_Head", new GameField(field_Head, nodeDeque));
		this.fields.put("NodeDeque_Current", new GameField(field_Current, nodeDeque));
	}
}
