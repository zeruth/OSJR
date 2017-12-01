package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class HashTable extends GameClass {

	public static final String hashTable = "gp";
	public static final String field_Head = "e";
	public static final String field_Tail = "k";
	public static final String field_Buckets = "w";
	public static final String field_Index = "u";
	public static final String field_Size = "a";

	public HashTable() {
		super(hashTable);
		this.fields.put("HashTable_Head", new GameField(field_Head, hashTable));
		this.fields.put("HashTable_Tail", new GameField(field_Tail, hashTable));
		this.fields.put("HashTable_Buckets", new GameField(field_Buckets, hashTable));
		this.fields.put("HashTable_Index", new GameField(field_Index, hashTable));
		this.fields.put("HashTable_Size", new GameField(field_Size, hashTable));
	}
}
