package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class AbstractSoundSystem extends GameClass {

	public static final String soundTaskDataProvider = "soundTaskDataProvider";
	public static final String samples = "samples";
	public static final String offset = "offset";

	public AbstractSoundSystem(Object reference) {
		super(Hooks.classNames.get("AbstractSoundSystem"));
		this.reference = reference;
	}

	public int getOffset() {
		return (int) fields.get(offset).getValue(reference);
	}

	public int[] getSamples() {
		return (int[]) fields.get(samples).getValue(reference);
	}

	public TaskDataProvider getTaskDataProvider() {
		return new TaskDataProvider(
				fields.get(soundTaskDataProvider).getValue(reference));
	}

}
