package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class234 extends RSClass{
	
	public static final String runeSprites = "runeSprites";

	public Class234() {
		super(Hooks.classNames.get("class234"));
	}
	
	public IndexedSprite[] getRuneSprites() {
		Object[] os = (Object[]) getField(runeSprites).getValue(reference);
		IndexedSprite[] runeSprites = new IndexedSprite[os.length];
		int i = 0;
		for (Object o : os) {
			runeSprites[i] = new IndexedSprite(o);
			i++;
		}
		return runeSprites;
	}

}