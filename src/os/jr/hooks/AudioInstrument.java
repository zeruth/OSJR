package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class AudioInstrument extends GameClass {

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
		return (int) fields.get(delayDecay).getValue(reference);
	}

	public int[] getDelays() {
		return (int[]) fields.get(delays).getValue(reference);
	}

	public int getDelayTime() {
		return (int) fields.get(delayTime).getValue(reference);
	}

	public int getDuration() {
		return (int) fields.get(duration).getValue(reference);
	}

	public SoundEffect3 getFilter() {
		return new SoundEffect3(fields.get(filter).getValue(reference));
	}

	public AudioEnvelope getFilterEnvelope() {
		return new AudioEnvelope(fields.get(filterEnvelope).getValue(reference));
	}

	public int[] getNOISE() {
		return (int[]) fields.get(NOISE).getValue(reference);
	}

	public int getOffset() {
		return (int) fields.get(offset).getValue(reference);
	}

	public int[] getOscillatorDelays() {
		return (int[]) fields.get(oscillatorDelays).getValue(reference);
	}

	public int[] getOscillatorPitch() {
		return (int[]) fields.get(oscillatorPitch).getValue(reference);
	}

	public int[] getOscillatorVolume() {
		return (int[]) fields.get(oscillatorVolume).getValue(reference);
	}

	public int[] getPhases() {
		return (int[]) fields.get(phases).getValue(reference);
	}

	public AudioEnvelope getPitch() {
		return new AudioEnvelope(fields.get(pitch).getValue(reference));
	}

	public int[] getPitchBaseSteps() {
		return (int[]) fields.get(pitchBaseSteps).getValue(reference);
	}

	public AudioEnvelope getPitchModifier() {
		return new AudioEnvelope(fields.get(pitchModifier).getValue(reference));
	}

	public AudioEnvelope getPitchModifierAmplitude() {
		return new AudioEnvelope(fields.get(pitchModifierAmplitude).getValue(reference));
	}

	public int[] getPitchSteps() {
		return (int[]) fields.get(pitchSteps).getValue(reference);
	}

	public AudioEnvelope getRelease() {
		return new AudioEnvelope(fields.get(release).getValue(reference));
	}

	public int[] getSamples() {
		return (int[]) fields.get(samples).getValue(reference);
	}

	public int[] getSINE() {
		return (int[]) fields.get(SINE).getValue(reference);
	}

	public AudioEnvelope getVolume() {
		return new AudioEnvelope(fields.get(volume).getValue(reference));
	}

	public AudioEnvelope getVolumeMultiplier() {
		return new AudioEnvelope(fields.get(volumeMultiplier).getValue(reference));
	}

	public AudioEnvelope getVolumeMultiplierAmplitude() {
		return new AudioEnvelope(
				fields.get(volumeMultiplierAmplitude).getValue(reference));
	}

	public int[] getVolumeSteps() {
		return (int[]) fields.get(volumeSteps).getValue(reference);
	}
}
