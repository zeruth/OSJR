package os.jr.hooks;

public abstract class AbstractIntegerNode0 extends Node {

	public static final String int1 = "int1";

	public AbstractIntegerNode0() {
		super(Hooks.classNames.get("AbstractIntegerNode0"));
	}

	public int getInt1() {
		return (int) fields.get(int1).getValue(reference);
	}

}
