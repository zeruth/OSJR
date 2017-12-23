package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class AbstractSoundSystem extends RSClass {

	public static final String soundTaskDataProvider = "soundTaskDataProvider";
	public static final String samples = "samples";
	public static final String offset = "offset";

	public AbstractSoundSystem(Object reference) {
		super(Hooks.classNames.get("AbstractSoundSystem"));
		this.reference = reference;
	}

	public int getOffset() {
		return (int) getField(offset).getValue(reference);
	}

	public int[] getSamples() {
		return (int[]) getField(samples).getValue(reference);
	}

	public TaskDataProvider getTaskDataProvider() {
		return new TaskDataProvider(
				getField(soundTaskDataProvider).getValue(reference));
	}

}
