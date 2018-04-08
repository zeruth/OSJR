package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Class138 extends RSClass {
	
	int baseX;

	public Class138(Object reference) {
		this.reference = reference;
		if (Hooks.class138 != null) {
			this.fields = Hooks.class138.fields;
			this.name = Hooks.class138.name;
			this.obfuscatedName = Hooks.class138.obfuscatedName;
		}
	}

	public int getBaseX() {
		this.baseX=(int) getValue(getField("baseX"));
		return this.baseX;
	}
}
