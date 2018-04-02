package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class BaseVarType extends RSClass {

	public BaseVarType(Object reference) {
		this.reference = reference;
		if (Hooks.baseVarType != null) {
			this.fields = Hooks.baseVarType.fields;
			this.name = Hooks.baseVarType.name;
			this.obfuscatedName = Hooks.baseVarType.obfuscatedName;
		}
	}

	public int getBaseY() {
		return (int) getValue(getField("baseY"));
	}
}
