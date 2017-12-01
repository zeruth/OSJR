package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class AnimationSequence extends GameClass {

	public static final String animationSequence = "jj";
	public static final String field_ControlFlow = "x";

	public AnimationSequence() {
		super(animationSequence);
		this.fields.put("AnimationSequence_ControlFlow", new GameField(field_ControlFlow, animationSequence));
	}

}
