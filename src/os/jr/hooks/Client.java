package os.jr.hooks;

import java.lang.reflect.Field;

import os.jr.game.Reflector;
import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;
import os.jr.utils.Settings;

public class Client extends GameClass{
	
	public final String SOMETHING = "SOMETHING";

	public static Settings settings;

	public Client(Object reference) {
		super("client");
		String client = "client";
		this.fields.put("SOMETHING", new GameField("bs", client));
		this.fields.put("Node_Prev", new GameField("bs", client));
		this.fields.put("Node_Next", new GameField("bs", client));
	}

}
