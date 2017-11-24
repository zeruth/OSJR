package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class NodeDeque extends GameClass{
	protected String nodeDequeHead = "NodeDeque_Head";
	protected String nodeDequeCurrent = "NodeDeque_Current";
	protected static String parentClass = "gx";
	
	public NodeDeque() {

		super(parentClass);
		this.fields.put("NodeDeque_Head", new GameField("b", parentClass));
		this.fields.put("NodeDeque_Current", new GameField("s", parentClass));
		// TODO Auto-generated constructor stub
	}
}
