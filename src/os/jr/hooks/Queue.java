package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Queue extends GameClass{

	public Queue() {
		super("gy");
		String queue = "gy";
		this.fields.put("Queue_Head", new GameField("d", queue));	
	}

}
