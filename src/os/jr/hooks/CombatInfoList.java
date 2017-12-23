package os.jr.hooks;

public class CombatInfoList extends Node {
	
	public static final String node = "node";
	public static final String current = "current";

	public CombatInfoList(Object reference) {
		super(Hooks.classNames.get("CombatInfoList"));
		this.reference = reference;
	}
	
	public Node getNode() {
		return new Node(getField(node).getValue(reference));
	}
	
	public Node getCurrent() {
		return new Node(getField(current).getValue(reference));
	}

}
