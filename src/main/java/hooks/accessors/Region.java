package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Region extends RSClass {

	public Region(Object reference) {
		this.reference = reference;
		if (Hooks.region != null) {
			this.fields = Hooks.region.fields;
			this.name = Hooks.region.name;
			this.obfuscatedName = Hooks.region.obfuscatedName;
		}
	}

	public GameObject[] getObjects() {
		Object[] os = (Object[]) getValue(getField("objects"));
		int i = 0;
		GameObject[] gos = new GameObject[os.length];
		for (Object o : os) {
			if (o != null) {
				gos[i] = new GameObject(o);
				i++;
			}
		}
		return gos;
	}

	public Tile getTile(int x, int y) {
		if (Hooks.client != null) {
			int bx = Client.getBaseX();
			int by = Client.getBaseY();

			int ax = x - bx;
			int ay = y - by;

			System.out.println(bx + " " + by);
			Object[][][] rsTiles = (Object[][][]) getValue(getField("tiles"));

			if (rsTiles[Client.getPlane()][ax][ay] != null)
				return new Tile(rsTiles[Client.getPlane()][ax][ay]);
		}

		return null;

	}

	public Tile[] getTiles() {
		int REGION_SIZE = 104;
		Object[][][] rsTiles = (Object[][][]) getValue(getField("tiles"));
		int z = Client.getPlane();
		int i = 0;
		Object[] temp = new Object[20000];
		for (int x = 0; x < REGION_SIZE; ++x) {
			for (int y = 0; y < REGION_SIZE; ++y) {
				Object tile = rsTiles[z][x][y];
				if (tile == null) {
					continue;
				}
				temp[i] = tile;
				i++;
			}
		}
		Tile[] tiles = new Tile[i];
		int k = 0;
		for (Object o : temp) {
			if (o != null) {
				tiles[k] = new Tile(o);
				k++;
			}
		}
		return tiles;
	}

}
