package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class ClassData extends GameClass {

	public static final String classData = "kb";
	public static final String field_Bytes = "f";
	public static final String field_Methods = "t";
	public static final String field_Fields = "u";

	public ClassData() {
		super(classData);
		this.fields.put("ClassData_Bytes", new GameField(field_Bytes, classData));
		this.fields.put("ClassData_Methods", new GameField(field_Methods, classData));
		this.fields.put("ClassData_Fields", new GameField(field_Fields, classData));
	}
}
