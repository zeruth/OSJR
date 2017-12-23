package os.jr.hooks;

public class BoundingBox extends Node {

	public static final String indexInterfaces = "indexInterfaces";

	public BoundingBox() {
		super(Hooks.classNames.get("BoundingBox"));
	}

	public BoundingBox(String string) {
		super(string);
	}

	public IndexData getIndexInterfaces() {
		return new IndexData(getField(indexInterfaces).getValue(reference));
	}

}
