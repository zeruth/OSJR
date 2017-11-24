package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class NodeDeque extends GameClass{
	protected String nodeDequeHead = "NodeDeque_Head";
	protected String nodeDequeCurrent = "NodeDeque_Current";
	
	public NodeDeque() {
		super("gl");
		String nodeDeque = "gl";
		this.fields.put("NodeDeque_Head", new GameField("d", nodeDeque));
		this.fields.put("NodeDeque_Current", new GameField("x", nodeDeque));
	}
}
