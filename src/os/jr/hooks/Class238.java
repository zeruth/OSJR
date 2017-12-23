package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class238 extends GameClass{
	
	public static final String ItemDefinition_modelIndexCache_ = "ItemDefinition_modelIndexCache";

	public Class238() {
		super(Hooks.classNames.get("class238"));
	}
	
	public IndexDataBase ItemDefinition_modelIndexCache() {
		return new IndexDataBase(fields.get(ItemDefinition_modelIndexCache_).getValue(reference));
	}

}