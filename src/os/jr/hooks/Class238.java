package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class238 extends RSClass{
	
	public static final String ItemDefinition_modelIndexCache_ = "ItemDefinition_modelIndexCache";

	public Class238() {
		super(Hooks.classNames.get("class238"));
	}
	
	public IndexDataBase ItemDefinition_modelIndexCache() {
		return new IndexDataBase(getField(ItemDefinition_modelIndexCache_).getValue(reference));
	}

}