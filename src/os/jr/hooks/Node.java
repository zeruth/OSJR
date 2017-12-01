package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Node extends GameClass {

	public static final String node = "gn";
	public static final String field_UID = "cs";
	public static final String field_Prev = "cr";
	public static final String field_Next = "cz";

	public final String NODE_UID = "Node_UID";
	public final String NODE_PREV = "Node_Prev";
	public final String NODE_NEXT = "Node_Next";

	public Node() {
		super(node);
		this.fields.put("Node_UID", new GameField(field_UID, node));
		this.fields.put("Node_Prev", new GameField(field_Prev, node));
		this.fields.put("Node_Next", new GameField(field_Next, node));
	}

	public Node(Object reference) {
		super(node);
		this.fields.put("Node_UID", new GameField(field_UID, node));
		this.fields.put("Node_Prev", new GameField(field_Prev, node));
		this.fields.put("Node_Next", new GameField(field_Next, node));
	}

	public Object getNext() {
		return fields.get("Node_Next").getValue(reference);
	}

}
