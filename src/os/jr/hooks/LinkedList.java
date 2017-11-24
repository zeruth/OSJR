package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class LinkedList extends GameClass{

	public LinkedList() {
		super("gl");
		String linkedList = "gl";
		this.fields.put("LinkedList_Head", new GameField("d", linkedList));
		this.fields.put("LinkedList_Current", new GameField("x", linkedList));
	}
}
