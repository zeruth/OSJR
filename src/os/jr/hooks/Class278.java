package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class278 extends RSClass{
	
	public static final String titlemuteSprite = "titlemuteSprite";

	public Class278() {
		super(Hooks.classNames.get("class278"));
	}
	
	public IndexedSprite[] getTitlemuteSprite() {
		Object[] os = (Object[]) getField(titlemuteSprite).getValue(reference);
		IndexedSprite[] titlemuteSprite = new IndexedSprite[os.length];
		int i = 0;
		for (Object o : os) {
			titlemuteSprite[i] = new IndexedSprite(o);
			i++;
		}
		return titlemuteSprite;
	}

}