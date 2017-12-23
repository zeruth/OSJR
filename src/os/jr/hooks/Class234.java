package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class234 extends GameClass{
	
	public static final String runeSprites = "runeSprites";

	public Class234() {
		super(Hooks.classNames.get("class234"));
	}
	
	public IndexedSprite[] getRuneSprites() {
		Object[] os = (Object[]) fields.get(runeSprites).getValue(reference);
		IndexedSprite[] runeSprites = new IndexedSprite[os.length];
		int i = 0;
		for (Object o : os) {
			runeSprites[i] = new IndexedSprite(o);
			i++;
		}
		return runeSprites;
	}

}