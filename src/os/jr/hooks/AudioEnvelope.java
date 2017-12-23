package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class AudioEnvelope extends RSClass {

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
		return (int) getField(amplitude).getValue(reference);
	}

	public int[] getDurations() {
		return (int[]) getField(durations).getValue(reference);
	}

	public int getEnd() {
		return (int) getField(end).getValue(reference);
	}

	public int getForm() {
		return (int) getField(form).getValue(reference);
	}

	public int getMax() {
		return (int) getField(max).getValue(reference);
	}

	public int getPhaseIndex() {
		return (int) getField(phaseIndex).getValue(reference);
	}

	public int[] getPhases() {
		return (int[]) getField(phases).getValue(reference);
	}

	public int getSegments() {
		return (int) getField(segments).getValue(reference);
	}

	public int getStart() {
		return (int) getField(start).getValue(reference);
	}

	public int getTicks() {
		return (int) getField(ticks).getValue(reference);
	}
}
