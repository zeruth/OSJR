package os.jr.hooks;

import java.awt.Canvas;

import javax.swing.JFrame;

import os.jr.boot.Boot;
import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class GameShell extends GameClass{
	
	public final String GAME_SHELL_CANVAS = "GameShell_Canvas";
	public final String GAME_SHELL_FRAME = "GameShell_Frame";

	public GameShell() {
		super("bs");
		String gameShell = "bs";
		
		this.fields.put("GameShell_Canvas", new GameField("al", gameShell));
		this.fields.put("GameShell_Frame", new GameField("au", gameShell));
	}
	
	public Canvas getCanvas() {
		Canvas c = (Canvas)getFieldValue(GAME_SHELL_CANVAS, Boot.rootReference);
		return c;
	}
	public JFrame getFrame() {
		JFrame f = (JFrame)getFieldValue(GAME_SHELL_FRAME, Boot.rootReference);
		return f;
	}

}
