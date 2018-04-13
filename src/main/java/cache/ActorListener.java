package cache;

import java.awt.Graphics;

import hooks.Hooks;
import hooks.accessors.Npc;
import hooks.accessors.Player;
import paint.PaintListener;

public class ActorListener implements PaintListener{
	
	public static Player[] players;
	public static Npc[] npcs;
	int tick = 0;

	@Override
	public void onRepaint(Graphics g) {
		if (this.tick>40) {
			if (Hooks.client != null)
				if (Hooks.client.isLoggedIn()) {
					Player[] ps = Hooks.client.getCachedPlayers();
					Npc[] ns = Hooks.client.getCachedNpcs();
					ActorListener.players = ps;
					ActorListener.npcs = ns;
				}	
			this.tick=0;
		} else {
			this.tick++;
		}

	}

}
