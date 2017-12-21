package os.jr.hooks;

public class Area extends CacheableNode {

	public static String mapAreaType = "mapAreaType";
	public static String areaSpriteCache = "areaSpriteCache";
	public static String spriteID = "spriteId";
	public static String name = "name";

	public Area(Object reference) {
		super(Hooks.classNames.get("Area"));
		this.reference = reference;
	}

	public NodeCache getAreaSpriteCache() {
		return new NodeCache(fields.get(areaSpriteCache).getValue(reference));
	}

	public Area[] getMapAreaType() {
		Object[] os = (Object[]) fields.get(mapAreaType).getValue(reference);
		Area[] mapAreaType = new Area[os.length];
		int count = 0;
		for (Object o : os) {
			mapAreaType[count] = new Area(o);
			count++;
		}
		return mapAreaType;
	}

	public String getName() {
		return (String) fields.get(name).getValue(reference);
	}

	public int getSpriteID() {
		return (int) fields.get(spriteID).getValue(reference);
	}

}
