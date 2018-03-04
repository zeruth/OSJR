package os.jr.hooks.model;

import os.jr.hooks.Hooks;
import os.jr.hooks.HooksLoader;

public class RSClass {

	public String refactoredName = "";
	public String obfuscatedName = "";
	public Object reference;

	public RSField[] fields;

	public RSClass(String obfuscatedName) {
		this.obfuscatedName = obfuscatedName;
		this.refactoredName = Hooks.refactoredClassNames.get(obfuscatedName);
	}

	public RSField getField(String fieldName) {
		if (fields == null)
			for (RSHook hook : HooksLoader.hooks) {
				if (hook.rsClass.refactoredName.compareTo(refactoredName) == 0) {
					fields = hook.rsFields;
				}
			}

		for (RSField field : fields) {
			if (field.refactoredName.compareTo(fieldName) == 0) {
				return field;
			}
		}
		return null;
	}
}
