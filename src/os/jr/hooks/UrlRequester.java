package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class UrlRequester extends RSClass {

	public UrlRequester(Object reference) {
		super(Hooks.classNames.get("UrlRequester"));
		this.reference = reference;
	}

}
