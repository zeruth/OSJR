package paint;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import game.Game;
import game.LoaderWindow;

public class GameCanvas extends Canvas {

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

		Graphics botGraphics = LoaderWindow.game.gamePaint();

		if (botGraphics != null) {
			return botGraphics;
		} else {
			return super.getGraphics();
		}
	}
}
