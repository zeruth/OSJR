package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class18 extends GameClass {
	
	public static final String headIconsPk = "headIconsPk";

	public Class18() {
		super(Hooks.classNames.get("class18"));
	}
	
	public SpritePixels[] getHeadIconsPk() {
		Object[] os = (Object[]) fields.get(headIconsPk).getValue(reference); 
		SpritePixels[] headIconsPk = new SpritePixels[os.length];
		int i = 0;
		for (Object o : os) {
			headIconsPk[i] = new SpritePixels(o);
			i++;
		}
		return headIconsPk;
	}

}