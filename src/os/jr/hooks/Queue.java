package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Queue extends GameClass {

	public static final String queue = "gx";
	public static final String field_Head = "a";
	
	public static final String QUEUE_HEAD = "Queue_Head";

	public Queue() {
		super(queue);
		this.fields.put("Queue_Head", new GameField(field_Head, queue));
	}
	
	public Node getHead() {
		return new Node(fields.get(QUEUE_HEAD).getValue(reference));
	}

}
