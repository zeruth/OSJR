package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class NodeDeque extends GameClass{
	protected String nodeDequeHead = "NodeDeque_Head";
	protected String nodeDequeCurrent = "NodeDeque_Current";
	
	public NodeDeque() {
		this.className = "gx";
		this.fields.put("NodeDeque", new GameField("b"));
		this.fields.put("NodeDeque", new GameField("s"));
	}

}
