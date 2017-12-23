package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class AudioInstrument extends RSClass {

	public static final String samples = "samples";
	public static final String NOISE = "NOISE";
	public static final String SINE = "SINE";
	public static final String phases = "phases";
	public static final String delays = "delays";
	public static final String volumeSteps = "volumeSteps";
	public static final String pitchSteps = "pitchSteps";
	public static final String pitchBaseSteps = "pitchBaseSteps";
	public static final String pitch = "pitch";
	public static final String volume = "volume";
	public static final String pitchModifier = "pitchModifier";
	public static final String pitchModifierAmplitude = "pitchModifierAmplitude";
	public static final String volumeMultiplier = "volumeMultiplier";
	public static final String volumeMultiplierAmplitude = "volumeMultiplierAmplitude";
	public static final String release = "release";
	public static final String oscillatorVolume = "oscillatorVolume";
	public static final String oscillatorPitch = "oscillatorPitch";
	public static final String oscillatorDelays = "oscillatorDelays";
	public static final String delayTime = "delayTime";
	public static final String delayDecay = "delayDecay";
	public static final String filter = "filter";
	public static final String filterEnvelope = "filterEnvelope";
	public static final String duration = "duration";
	public static final String offset = "offset";

	public AudioInstrument() {
		super(Hooks.classNames.get("AudioInstrument"));
	}

	public int getDelayDecay() {
		return (int) getField(delayDecay).getValue(reference);
	}

	public int[] getDelays() {
		return (int[]) getField(delays).getValue(reference);
	}

	public int getDelayTime() {
		return (int) getField(delayTime).getValue(reference);
	}

	public int getDuration() {
		return (int) getField(duration).getValue(reference);
	}

	public SoundEffect3 getFilter() {
		return new SoundEffect3(getField(filter).getValue(reference));
	}

	public AudioEnvelope getFilterEnvelope() {
		return new AudioEnvelope(getField(filterEnvelope).getValue(reference));
	}

	public int[] getNOISE() {
		return (int[]) getField(NOISE).getValue(reference);
	}

	public int getOffset() {
		return (int) getField(offset).getValue(reference);
	}

	public int[] getOscillatorDelays() {
		return (int[]) getField(oscillatorDelays).getValue(reference);
	}

	public int[] getOscillatorPitch() {
		return (int[]) getField(oscillatorPitch).getValue(reference);
	}

	public int[] getOscillatorVolume() {
		return (int[]) getField(oscillatorVolume).getValue(reference);
	}

	public int[] getPhases() {
		return (int[]) getField(phases).getValue(reference);
	}

	public AudioEnvelope getPitch() {
		return new AudioEnvelope(getField(pitch).getValue(reference));
	}

	public int[] getPitchBaseSteps() {
		return (int[]) getField(pitchBaseSteps).getValue(reference);
	}

	public AudioEnvelope getPitchModifier() {
		return new AudioEnvelope(getField(pitchModifier).getValue(reference));
	}

	public AudioEnvelope getPitchModifierAmplitude() {
		return new AudioEnvelope(getField(pitchModifierAmplitude).getValue(reference));
	}

	public int[] getPitchSteps() {
		return (int[]) getField(pitchSteps).getValue(reference);
	}

	public AudioEnvelope getRelease() {
		return new AudioEnvelope(getField(release).getValue(reference));
	}

	public int[] getSamples() {
		return (int[]) getField(samples).getValue(reference);
	}

	public int[] getSINE() {
		return (int[]) getField(SINE).getValue(reference);
	}

	public AudioEnvelope getVolume() {
		return new AudioEnvelope(getField(volume).getValue(reference));
	}

	public AudioEnvelope getVolumeMultiplier() {
		return new AudioEnvelope(getField(volumeMultiplier).getValue(reference));
	}

	public AudioEnvelope getVolumeMultiplierAmplitude() {
		return new AudioEnvelope(
				getField(volumeMultiplierAmplitude).getValue(reference));
	}

	public int[] getVolumeSteps() {
		return (int[]) getField(volumeSteps).getValue(reference);
	}
}
