package os.jr.game.accessors;

import java.util.Hashtable;

public class Cache {
	private Hashtable<String, Object> cache;

	public Cache() {
		this.cache = new Hashtable<String, Object>();
	}

	public Object get(String signature) {
		return cache.get(signature);
	}

	public void put(String signature, Object o) {
		cache.put(signature, o);
	}

	public void clear() {
		cache.clear();
	}

}
