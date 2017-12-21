package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class AudioEnvelope extends GameClass {

	public static final String segments = "segments";
	public static final String durations = "durations";
	public static final String phases = "phases";
	public static final String start = "start";
	public static final String end = "end";
	public static final String form = "form";
	public static final String ticks = "ticks";
	public static final String phaseIndex = "phaseIndex";
	public static final String step = "step";
	public static final String amplitude = "amplitude";
	public static final String max = "max";

	public AudioEnvelope(Object reference) {
		super(Hooks.classNames.get("AudioEnvelope"));
		this.reference = reference;
	}

	public int getAmplitude() {
		return (int) Hooks.selector.audioEnvelope.fields.get(amplitude).getValue(reference);
	}

	public int[] getDurations() {
		return (int[]) Hooks.selector.audioEnvelope.fields.get(durations).getValue(reference);
	}

	public int getEnd() {
		return (int) Hooks.selector.audioEnvelope.fields.get(end).getValue(reference);
	}

	public int getForm() {
		return (int) Hooks.selector.audioEnvelope.fields.get(form).getValue(reference);
	}

	public int getMax() {
		return (int) Hooks.selector.audioEnvelope.fields.get(max).getValue(reference);
	}

	public int getPhaseIndex() {
		return (int) Hooks.selector.audioEnvelope.fields.get(phaseIndex).getValue(reference);
	}

	public int[] getPhases() {
		return (int[]) Hooks.selector.audioEnvelope.fields.get(phases).getValue(reference);
	}

	public int getSegments() {
		return (int) Hooks.selector.audioEnvelope.fields.get(segments).getValue(reference);
	}

	public int getStart() {
		return (int) Hooks.selector.audioEnvelope.fields.get(start).getValue(reference);
	}

	public int getTicks() {
		return (int) Hooks.selector.audioEnvelope.fields.get(ticks).getValue(reference);
	}
}
