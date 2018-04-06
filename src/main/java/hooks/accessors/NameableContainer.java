package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class NameableContainer extends RSClass {

	public NameableContainer(Object reference) {
		this.reference = reference;
		if (Hooks.nameableContainer != null) {
			this.fields = Hooks.nameableContainer.fields;
			this.name = Hooks.nameableContainer.name;
			this.obfuscatedName = Hooks.nameableContainer.obfuscatedName;
		}
	}

	public Nameable[] getNameables() {
		Object[] os = (Object[]) getValue(getField("nameables"));
		int i = 0;
		for (Object o : os) {
			if (o != null)
				i++;
		}
		Nameable[] nameables = new Nameable[i];
		int k = 0;
		for (Object o : os) {
			if (o != null) {
				nameables[k] = new Nameable(o);
				k++;
			}
		}
		return nameables;
	}

}
