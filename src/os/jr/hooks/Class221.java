package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class221 extends RSClass{
	
	public static final String slFlagSprites = "slFlagSprites";

	public Class221() {
		super(Hooks.classNames.get("class221"));
	}
	
	public IndexedSprite[] getSlFlagSprites() {
		Object[] os = (Object[]) getField(slFlagSprites).getValue(reference);
		IndexedSprite[] slFlagSprites = new IndexedSprite[os.length];
		int i = 0;
		for (Object o : os) {
			slFlagSprites[i] = new IndexedSprite(o);
			i++;
		}
		return slFlagSprites;
	}

}