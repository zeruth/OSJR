package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class AbstractSoundSystem extends GameClass {

	public static final String soundTaskDataProvider = "soundTaskDataProvider";
	public static final String samples = "samples";
	public static final String offset = "offset";

	public AbstractSoundSystem() {
		super(Hooks.classNames.get("AbstractSoundSystem"));
	}

	public int getOffset() {
		return (int) Hooks.selector.abstractSoundSystem.fields.get(offset).getValue(reference);
	}

	public int[] getSamples() {
		return (int[]) Hooks.selector.abstractSoundSystem.fields.get(samples).getValue(reference);
	}

	public TaskDataProvider getTaskDataProvider() {
		return new TaskDataProvider(
				Hooks.selector.abstractSoundSystem.fields.get(soundTaskDataProvider).getValue(reference));
	}

}
