package os.jr.hooks.model;

import os.jr.hooks.Hooks;
import os.jr.hooks.HooksLoader;

public class RSClass {

    public String obfuscatedName;
    public String name;
    public RSField[] fields;
    
    public Object reference = null;

	public RSClass(String obfuscatedName) {
		this.obfuscatedName = obfuscatedName;
		this.name = Hooks.refactoredClassNames.get(obfuscatedName);
	}

	public RSField getField(String fieldName) {
		if (fields == null)
			for (RSClass hook : HooksLoader.hooks) {
				if (hook.name.compareTo(name) == 0) {
					fields = hook.fields;
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
