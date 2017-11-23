package os.jr.hooks.model;

public class GameField {
	
	public String fieldName;
	public int multiplier;
	
	public GameField(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public GameField(String fieldName, int multiplier) {
		this.fieldName = fieldName;
		this.multiplier = multiplier;
	}

}
