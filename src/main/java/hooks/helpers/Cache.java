package hooks.helpers;

import java.util.Hashtable;

public class Cache {
	private Hashtable<String, Object> cache;

	public Cache() {
		this.cache = new Hashtable<>();
	}

	// http://stackoverflow.com/questions/442747/getting-the-name-of-the-current-executing-method/8592871#8592871

	public void clear() {
		this.cache.clear();
	}

	public Object get(String signature) {
		return this.cache.get(signature);
	}

	public void put(String signature, Object o) {
		this.cache.put(signature, o);
	}

}
