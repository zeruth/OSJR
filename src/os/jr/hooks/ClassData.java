package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class ClassData extends GameClass{

	public ClassData() {
		super("km");
		String classData = "km";
		this.fields.put("ClassData_Bytes", new GameField("m", classData));	
		this.fields.put("ClassData_Methods", new GameField("t", classData));	
		this.fields.put("ClassData_Fields", new GameField("v", classData));	
	}
}
