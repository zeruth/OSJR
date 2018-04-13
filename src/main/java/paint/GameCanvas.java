package paint;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import game.Game;

public class GameCanvas extends Canvas {
	Graphics botGraphics;

	private static final long serialVersionUID = 1L;

	@Override
	public Image createImage(int width, int height) {
		return new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}

	@Override
	public Graphics getGraphics() {
		if (Game.vanilla) {
			return super.getGraphics();
		}

		this.botGraphics = Game.gamePaint();

		if (this.botGraphics != null) {
			return this.botGraphics;
		} else {
			return super.getGraphics();
		}
	}
}
