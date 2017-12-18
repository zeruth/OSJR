package os.jr.hooks;

import os.jr.boot.Boot;

public class Hooks {

	public static Hooks selector;
	public static int hookCount = 0;

	public AbstractByteBuffer abstractByteBuffer = new AbstractByteBuffer();
	public AbstractIntegerNode0 abstractIntegerNode0 = new AbstractIntegerNode0();
	public AbstractSoundSystem abstractSoundSystem = new AbstractSoundSystem();
	public Actor actor = new Actor();
	public Area area = new Area();
	public AttackOption attackOption = new AttackOption();
	public AudioEnvelope audioEnvelope = new AudioEnvelope();
	public AudioInstrument audioInstrument = new AudioInstrument();
	
	public static void init() {
		try {
			selector = new Hooks();
		} catch (Exception e) {
			System.out.println("Client hooks outdated. Please update from github or update hooks yourself.");
			System.out.println("Running without hooks.");
			Boot.outdated = true;
			e.printStackTrace();
		}

	}

}
