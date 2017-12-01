package os.jr.hooks;

public class LocalPlayer extends Player {

	public final String PLAYER_NAME = "Player_Name";

	public LocalPlayer() {
		super(Player.player);
	}

	public LocalPlayer(Object reference) {
		super(Player.player);
		this.reference = reference;
	}

	public Actor asActor() {
		return new Actor(reference);
	}

}
