package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class37 extends RSClass{
	
	public static final String revision = "revision";
	public static final String widgetIndex = "widgetIndex";
	public static final String slStarSprites = "slStarSprites";
	public static final String indexModels = "indexModels";

	public Class37() {
		super(Hooks.classNames.get("class37"));
	}
	
	public int getRevision() {
		return (int) getField(revision).getValue(reference);
	}
	
	public IndexDataBase getWidgetIndex() {
		return new IndexDataBase(getField(widgetIndex).getValue(reference));
	}
	
	public IndexedSprite[] getSlStarSprites() {
		Object[] os = (Object[]) getField(slStarSprites).getValue(reference);
		IndexedSprite[] slStarSprites = new IndexedSprite[os.length];
		int i = 0;
		for (Object o : os) {
			slStarSprites[i] = new IndexedSprite(o);
			i++;
		}
		return slStarSprites;
	}
	
	public IndexData getIndexModels() {
		return new IndexData(getField(indexModels).getValue(reference));
	}

}