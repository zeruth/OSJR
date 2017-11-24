package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class AnimationSequence extends GameClass{

	public AnimationSequence() {
		super("jj");
		String animationSequence = "jj";
		this.fields.put("AnimationSequence_ControlFlow", new GameField("l", animationSequence));
	}

}
