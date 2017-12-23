package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class276 extends GameClass{
	
	public static final String huffman = "huffman";

	public Class276() {
		super(Hooks.classNames.get("class276"));
	}
	
	public Huffman getHuffman() {
		return new Huffman(fields.get(huffman).getValue(reference));
	}

}