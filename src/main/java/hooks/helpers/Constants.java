package hooks.helpers;

import java.awt.Dimension;

public class Constants {
	public static final int CLIENT_DEFAULT_ZOOM = 512;
	public static final int GAME_FIXED_WIDTH = 765;
	public static final int GAME_FIXED_HEIGHT = 503;
	public static final double GAME_FIXED_ASPECT_RATIO = (double) GAME_FIXED_WIDTH / (double) GAME_FIXED_HEIGHT;
	public static final Dimension GAME_FIXED_SIZE = new Dimension(GAME_FIXED_WIDTH, GAME_FIXED_HEIGHT);
}
