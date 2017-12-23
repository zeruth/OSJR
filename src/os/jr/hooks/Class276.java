package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class276 extends RSClass{
	
	public static final String huffman = "huffman";

	public Class276() {
		super(Hooks.classNames.get("class276"));
	}
	
	public Huffman getHuffman() {
		return new Huffman(getField(huffman).getValue(reference));
	}

}