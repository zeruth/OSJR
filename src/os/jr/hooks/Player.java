package os.jr.hooks;

public class Player extends Actor{
	
	public static final String name = "name";

	public Player(Object reference) {
		super(Hooks.classNames.get("Player"));
		this.reference=reference;
	}
	
	public String getName() {
		return (String) fields.get(name).getValue(reference);
	}

}
