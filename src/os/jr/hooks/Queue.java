package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Queue extends GameClass {

	public static final String queue = "gx";
	public static final String field_Head = "a";

	public Queue() {
		super(queue);
		this.fields.put("Queue_Head", new GameField(field_Head, queue));
	}

}
