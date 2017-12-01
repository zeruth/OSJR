package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class LinkedList extends GameClass {

	public static final String linkedList = "go";
	public static final String field_Head = "a";
	public static final String field_Current = "w";

	public LinkedList() {
		super(linkedList);
		this.fields.put("LinkedList_Head", new GameField(field_Head, linkedList));
		this.fields.put("LinkedList_Current", new GameField(field_Current, linkedList));
	}
}
