package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class GameObject extends GameClass{

	public GameObject() {
		super("ek");
		String gameObject = "ek";
		this.fields.put("GameObject_Render", new GameField("z", gameObject));
		this.fields.put("GameObject_ID", new GameField("n", gameObject, -1899654925));
		this.fields.put("GameObject_Flags", new GameField("c", gameObject, 1801845417));
		this.fields.put("GameObject_Orientation", new GameField("m", gameObject, -498878787));
		this.fields.put("GameObject_Plane", new GameField("d", gameObject, -1040235295));
		this.fields.put("GameObject_Height", new GameField("k", gameObject, 2113350775));
		this.fields.put("GameObject_WorldX", new GameField("v", gameObject, -1222975009));
		this.fields.put("GameObject_WorldY", new GameField("x", gameObject, 1850709219));
		this.fields.put("GameObject_LocalX", new GameField("b", gameObject, 920225325));
		this.fields.put("GameObject_LocalY", new GameField("p", gameObject, 1282150425));
		this.fields.put("GameObject_OffsetX", new GameField("t", gameObject, 958723559));
		this.fields.put("GameObject_OffsetY", new GameField("r", gameObject, 520453821));
	}

}
