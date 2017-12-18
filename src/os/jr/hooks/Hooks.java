package os.jr.hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import os.jr.boot.Boot;
import os.jr.hooks.model.RSClass;
import os.jr.utils.Settings;
import os.jr.utils.Utils;

public class Hooks {

	public static Hooks selector;
	public static int hookCount = 0;
	
	public static HashMap<String, String> classNames = new HashMap<String, String>();

	public AbstractByteBuffer abstractByteBuffer = new AbstractByteBuffer();
	public AbstractIntegerNode0 abstractIntegerNode0 = new AbstractIntegerNode0();
	public AbstractSoundSystem abstractSoundSystem = new AbstractSoundSystem();
	public Actor actor = new Actor();
	public Area area = new Area();
	public AttackOption attackOption = new AttackOption();
	public AudioEnvelope audioEnvelope = new AudioEnvelope();
	public AudioInstrument audioInstrument = new AudioInstrument();
	public BaseVarType baseVarType = new BaseVarType();
	public BoundingBox boundingBox = new BoundingBox();
	public BoundingBox2D boundingBox2D = new BoundingBox2D();
	public BoundingBox3D boundingBox3D = new BoundingBox3D();
	public Bounds bounds = new Bounds();
	public Buffer buffer = new Buffer();
	public BufferProvider bufferProvider = new BufferProvider();
	public BuildType buildType = new BuildType();
	public ByteArrayNode byteArrayNode = new ByteArrayNode();
	public CacheableNode cacheableNode = new CacheableNode();
	public CacheFile cacheFile = new CacheFile();
	public ChatLineBuffer chatLineBuffer = new ChatLineBuffer();
	public ClanMember clanMember = new ClanMember();
	public ClassInfo classInfo = new ClassInfo();
	public Client client = new Client();
	public ClientPacket clientPacket = new ClientPacket();
	public CodeBook codeBook = new CodeBook();
	public CollisionData collisionData = new CollisionData();

	public static void init() {
		try {
			loadClassDump();
			selector = new Hooks();
		} catch (Exception e) {
			System.out.println("Client hooks outdated. Please update from github or update hooks yourself.");
			System.out.println("Running without hooks.");
			Boot.outdated = true;
			e.printStackTrace();
		}

	}

	public static void loadClassDump() {
		File dir = new File("./Dumps/Classes/");
		for (File f : dir.listFiles()) {
			InputStream inputStream;
			try {
				inputStream = new FileInputStream(f);
				try (Reader reader = new InputStreamReader(inputStream, "UTF-8")) {
					Gson gson = new GsonBuilder().create();
					RSClass rsClass = gson.fromJson(reader, RSClass.class);
					System.out.println("Loaded "+rsClass.refactoredName + " "+rsClass.obfuscatedName);
					classNames.put(rsClass.refactoredName, rsClass.obfuscatedName);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
