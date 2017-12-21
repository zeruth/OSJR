package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class AudioInstrument extends GameClass{
	
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

	public int[] getSamples() {
		return (int[]) Hooks.selector.audioInstrument.fields.get(samples).getValue(reference);
	}
	
	public int[] getNOISE() {
		return (int[]) Hooks.selector.audioInstrument.fields.get(NOISE).getValue(reference);
	}
	
	public int[] getSINE() {
		return (int[]) Hooks.selector.audioInstrument.fields.get(SINE).getValue(reference);
	}
	
	public int[] getPhases() {
		return (int[]) Hooks.selector.audioInstrument.fields.get(phases).getValue(reference);
	}
	
	public int[] getDelays() {
		return (int[]) Hooks.selector.audioInstrument.fields.get(delays).getValue(reference);
	}
	
	public int[] getVolumeSteps() {
		return (int[]) Hooks.selector.audioInstrument.fields.get(volumeSteps).getValue(reference);
	}
	
	public int[] getPitchSteps() {
		return (int[]) Hooks.selector.audioInstrument.fields.get(pitchSteps).getValue(reference);
	}
	
	public int[] getPitchBaseSteps() {
		return (int[]) Hooks.selector.audioInstrument.fields.get(pitchBaseSteps).getValue(reference);
	}
	
	public AudioEnvelope getPitch() {
		return new AudioEnvelope(Hooks.selector.audioInstrument.fields.get(pitch).getValue(reference));
	}
	
	public AudioEnvelope getVolume() {
		return new AudioEnvelope(Hooks.selector.audioInstrument.fields.get(volume).getValue(reference));
	}
	
	public AudioEnvelope getPitchModifier() {
		return new AudioEnvelope(Hooks.selector.audioInstrument.fields.get(pitchModifier).getValue(reference));
	}
	
	public AudioEnvelope getPitchModifierAmplitude() {
		return new AudioEnvelope(Hooks.selector.audioInstrument.fields.get(pitchModifierAmplitude).getValue(reference));
	}
	
	public AudioEnvelope getVolumeMultiplier() {
		return new AudioEnvelope(Hooks.selector.audioInstrument.fields.get(volumeMultiplier).getValue(reference));
	}
	
	public AudioEnvelope getVolumeMultiplierAmplitude() {
		return new AudioEnvelope(Hooks.selector.audioInstrument.fields.get(volumeMultiplierAmplitude).getValue(reference));
	}
	
	public AudioEnvelope getRelease() {
		return new AudioEnvelope(Hooks.selector.audioInstrument.fields.get(release).getValue(reference));
	}
	
	public int[] getOscillatorVolume() {
		return (int[]) Hooks.selector.audioInstrument.fields.get(oscillatorVolume).getValue(reference);
	}
	
	public int[] getOscillatorPitch() {
		return (int[]) Hooks.selector.audioInstrument.fields.get(oscillatorPitch).getValue(reference);
	}
	
	public int[] getOscillatorDelays() {
		return (int[]) Hooks.selector.audioInstrument.fields.get(oscillatorDelays).getValue(reference);
	}
	
	public int getDelayTime() {
		return (int) Hooks.selector.audioInstrument.fields.get(delayTime).getValue(reference);
	}
	
	public int getDelayDecay() {
		return (int) Hooks.selector.audioInstrument.fields.get(delayDecay).getValue(reference);
	}
	
	public SoundEffect3 getFilter() {
		return new SoundEffect3(Hooks.selector.audioInstrument.fields.get(filter).getValue(reference));
	}
	
	public AudioEnvelope getFilterEnvelope() {
		return new AudioEnvelope(Hooks.selector.audioInstrument.fields.get(filterEnvelope).getValue(reference));
	}
	
	public int getDuration() {
		return (int) Hooks.selector.audioInstrument.fields.get(duration).getValue(reference);
	}
	
	public int getOffset() {
		return (int) Hooks.selector.audioInstrument.fields.get(offset).getValue(reference);
	}
}
