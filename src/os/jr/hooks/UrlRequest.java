package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class UrlRequest extends RSClass {

	public UrlRequest(Object reference) {
		super(Hooks.classNames.get("UrlRequest"));
		this.reference = reference;
	}

}
