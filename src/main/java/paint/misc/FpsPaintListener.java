package paint.misc;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import game.OSRSLauncher;
import game.Settings;
import hooks.Hooks;
import hooks.accessors.Client;
import paint.PaintListener;

public class FpsPaintListener implements PaintListener {

	FontMetrics fm;
	String stringFps;
	int x;
	int fps;

	public FpsPaintListener(Client game) {
	}

	@Override
	public void onRepaint(Graphics g) {
		if (Settings.SHOW_FPS) {
			if (Client.isLoaded()) {
				this.fm = g.getFontMetrics();
				this.stringFps = "" + Hooks.gameEngine.getFps();
				this.x = OSRSLauncher.loaderWindow.getWidth() - this.fm.stringWidth(this.stringFps) - 17;

				this.fps = Hooks.gameEngine.getFps();
				if (this.fps >= 50) {
					g.setColor(Color.cyan);
				} else if (this.fps >= 40 && this.fps < 50) {
					g.setColor(Color.green);
				} else if (this.fps >= 30 && this.fps < 40) {
					g.setColor(Color.yellow);
				} else {
					g.setColor(Color.red);
				}
				g.drawString(this.stringFps, this.x, 15);
			}
		}
	}

}
