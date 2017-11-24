package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class HashTable extends GameClass{

	public HashTable() {
		super("gn");
		String hashTable = "gn";
		this.fields.put("HashTable_Head", new GameField("k", hashTable));	
		this.fields.put("HashTable_Tail", new GameField("z", hashTable));	
		this.fields.put("HashTable_Buckets", new GameField("x", hashTable));	
		this.fields.put("HashTable_Index", new GameField("v", hashTable));	
		this.fields.put("HashTable_Size", new GameField("d", hashTable));	
		}
}
