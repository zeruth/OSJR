package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Node extends GameClass {
	public String nodeUID = "Node_UID";
	public String nodePrev = "Node_Prev";
	public String nodeNext = "Node_Next";
	
	public Node() {
		this.className = "gt";
		this.fields.put("Node_UID", new GameField("cn"));
		this.fields.put("Node_Prev", new GameField("ca"));
		this.fields.put("Node_Next", new GameField("cp"));
	}
}
