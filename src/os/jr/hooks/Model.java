package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Model extends GameClass {

	public static final String model = "ef";
	public static final String field_IndicesX = "j";
	public static final String field_IndicesY = "x";
	public static final String field_IndicesZ = "c";
	public static final String field_IndicesLength = "g";
	public static final String field_VerticesX = "z";
	public static final String field_VerticesY = "t";
	public static final String field_VerticesZ = "f";
	public static final String field_VerticesLength = "u";
	public static final String field_TexIndicesX = "s";
	public static final String field_TexIndicesY = "n";
	public static final String field_TexIndicesZ = "y";
	public static final String field_TexVerticesX = "b";
	public static final String field_TexVerticesY = "h";
	public static final String field_TexVerticesZ = "d";
	public static final String field_TexVerticesLength = "q";
	public static final String field_ShadowIntesity = "ak";
	public static final String field_FitsSingleTile = "ab";

	public Model() {
		super(model);
		this.fields.put("Model_IndicesX", new GameField(field_IndicesX, model));
		this.fields.put("Model_IndicesY", new GameField(field_IndicesY, model));
		this.fields.put("Model_IndicesZ", new GameField(field_IndicesZ, model));
		this.fields.put("Model_IndicesLength", new GameField(field_IndicesLength, model));
		this.fields.put("Model_VerticesX", new GameField(field_VerticesX, model));
		this.fields.put("Model_VerticesY", new GameField(field_VerticesY, model));
		this.fields.put("Model_VerticesZ", new GameField(field_VerticesZ, model));
		this.fields.put("Model_VerticesLength", new GameField(field_VerticesLength, model));
		this.fields.put("Model_TexIndicesX", new GameField(field_TexIndicesX, model));
		this.fields.put("Model_TexIndicesY", new GameField(field_TexIndicesY, model));
		this.fields.put("Model_TexIndicesZ", new GameField(field_TexIndicesZ, model));
		this.fields.put("Model_TexVerticesX", new GameField(field_TexVerticesX, model));
		this.fields.put("Model_TexVerticesY", new GameField(field_TexVerticesY, model));
		this.fields.put("Model_TexVerticesZ", new GameField(field_TexVerticesZ, model));
		this.fields.put("Model_TexVerticesLength", new GameField(field_TexVerticesLength, model));
		this.fields.put("Model_ShadowIntensity", new GameField(field_ShadowIntesity, model));
		this.fields.put("Model_FitsSingleTile", new GameField(field_FitsSingleTile, model));
	}

}
