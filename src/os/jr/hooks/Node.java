package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Node extends GameClass {
	public final String NODE_UID = "Node_UID";
	public final String NODE_PREV = "Node_Prev";
	public final String NODE_NEXT = "Node_Next";
	
	public Node() {
		super("gf");
		String node = "gf";
		this.fields.put("Node_UID", new GameField("cc", node));
		this.fields.put("Node_Prev", new GameField("cq", node));
		this.fields.put("Node_Next", new GameField("ck", node));
	}

	public Node(Object reference) {
		super("gf");
		String node = "gf";
		this.reference = reference;
		this.fields.put("Node_UID", new GameField("cc", node));
		this.fields.put("Node_Prev", new GameField("cq", node));
		this.fields.put("Node_Next", new GameField("ck", node));
	}
	
	public Object getNext() {
		return fields.get("Node_Next").getValue(reference);
	}

	
}
