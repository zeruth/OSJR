package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class CombatInfo2 extends RSClass {
	
	public static final String spriteCache = "spriteCache";
	public static final String healthScale = "healthScale";

	public CombatInfo2(Object reference) {
		super(Hooks.classNames.get("CombatInfo2"));
		this.reference = reference;
	}
	
	public NodeCache getSpriteCache() {
		return new NodeCache(getField(spriteCache).getValue(reference));
	}

}
