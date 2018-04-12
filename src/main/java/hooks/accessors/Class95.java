package hooks.accessors;

import java.util.Map;

import hooks.Hooks;
import hooks.model.RSClass;

public class Class95 extends RSClass {

	public Class95(Object reference) {
		this.reference = reference;
		if (Hooks.class95 != null) {
			this.fields = Hooks.class95.fields;
			this.name = Hooks.class95.name;
			this.obfuscatedName = Hooks.class95.obfuscatedName;
		}
	}

	public Map<Integer, Object> getChatLineMap() {
		@SuppressWarnings("unchecked")
		Map<Integer, Object> m = (Map<Integer, Object>) getValue(getField("chatLineMap"));
		return m;
	}
}
