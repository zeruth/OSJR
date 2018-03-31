package os.rs.hooks.helpers;

import java.util.Hashtable;

public class Cache {
	private Hashtable<String, Object> cache;

	public Cache() {
		this.cache = new Hashtable<String, Object>();
	}

	// http://stackoverflow.com/questions/442747/getting-the-name-of-the-current-executing-method/8592871#8592871

	public void clear() {
		cache.clear();
	}

	public Object get(String signature) {
		return cache.get(signature);
	}

	public void put(String signature, Object o) {
		cache.put(signature, o);
	}

}
