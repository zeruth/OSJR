package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Model extends GameClass{

	public Model() {
		super("eh");
		String model = "eh";
		this.fields.put("Model_IndicesX", new GameField("r", model));
		this.fields.put("Model_IndicesY", new GameField("l", model));
		this.fields.put("Model_IndicesZ", new GameField("u", model));
		this.fields.put("Model_IndicesLength", new GameField("p", model));
		this.fields.put("Model_VerticesX", new GameField("m", model));
		this.fields.put("Model_VerticesY", new GameField("b", model));
		this.fields.put("Model_VerticesZ", new GameField("t", model));
		this.fields.put("Model_VerticesLength", new GameField("v", model));
		this.fields.put("Model_TexIndicesX", new GameField("n", model));
		this.fields.put("Model_TexIndicesY", new GameField("c", model));
		this.fields.put("Model_TexIndicesZ", new GameField("y", model));
		this.fields.put("Model_TexVerticesX", new GameField("i", model));
		this.fields.put("Model_TexVerticesY", new GameField("o", model));
		this.fields.put("Model_TexVerticesZ", new GameField("w", model));
		this.fields.put("Model_TexVerticesLength", new GameField("h", model));
		this.fields.put("Model_ShadowIntensity", new GameField("ax", model));
		this.fields.put("Model_FitsSingleTile", new GameField("ah", model));
	}

}
