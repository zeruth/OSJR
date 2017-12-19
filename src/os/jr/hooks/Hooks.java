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
	public static int rsFieldCount = 0;
	public static int rsClassCount = 0;
	
	public static HashMap<String, String> classNames = new HashMap<String, String>();

	public AbstractByteBuffer abstractByteBuffer = new AbstractByteBuffer() {};
	public AbstractIntegerNode0 abstractIntegerNode0 = new AbstractIntegerNode0() {};
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
	public Client client = new Client(Boot.rootReference);
	public ClientPacket clientPacket = new ClientPacket();
	public CodeBook codeBook = new CodeBook();
	public CollisionData collisionData = new CollisionData();
	public CombatInfo1 combatInfo1 = new CombatInfo1();
	public CombatInfo2 combatInfo2 = new CombatInfo2();
	public CombatInfoList combatInfoList = new CombatInfoList(null);
	public ContextMenuRow contextMenuRow = new ContextMenuRow();
	public Coordinates coordinates = new Coordinates();
	public DecorativeObject decorativeObject = new DecorativeObject();
	public Deque deque = new Deque();
	public DirectByteBuffer directByteBuffer = new DirectByteBuffer();
	public DState dState = new DState();
	public DynamicObject dynamicObject = new DynamicObject();
	public Enum enum_ = new Enum();
	public FaceNormal faceNormal = new FaceNormal();
	public FileOnDisk fileOnDisk = new FileOnDisk();
	public FileRequest fileRequest = new FileRequest();
	public FileSystem fileSystem = new FileSystem();
	public Floor1 floor1 = new Floor1();
	public FloorUnderlayDefinition floorUnderlayDefinition = new FloorUnderlayDefinition();
	public FontName fontName = new FontName();
	public Fonts fonts = new Fonts();
	public FontTypeFace fontTypeFace = new FontTypeFace();
	public Frame frame = new Frame();
	public FrameMap frameMap = new FrameMap();
	public Frames frames = new Frames();
	public Friend friend = new Friend();
	public FriendLoginUpdate friendLoginUpdate = new FriendLoginUpdate();
	public GameEngine gameEngine = new GameEngine();
	public GameObject gameObject = new GameObject();
	public GrandExchangeEvent grandExchangeEvent = new GrandExchangeEvent();
	public GrandExchangeEvents grandExchangeEvents = new GrandExchangeEvents();
	public GrandExchangeOffer grandExchangeOffer = new GrandExchangeOffer();
	public Graphics3D graphics3D = new Graphics3D();
	public GraphicsObject graphicsObject = new GraphicsObject();
	public GroundObject groundObject = new GroundObject();
	public GZipDecompressor gzipDecompressor = new GZipDecompressor();
	public HashTable hashTable = new HashTable();
	public HashTableIterator hashTableIterator = new HashTableIterator();
	public Huffman huffman = new Huffman();
	public Identifiers identifiers = new Identifiers();
	public Ignore ignore = new Ignore();
	public IndexData indexData = new IndexData();
	public IndexDataBase indexDataBase = new IndexDataBase();
	public IndexedSprite indexedSprite = new IndexedSprite();
	public IndexFile indexFile = new IndexFile();
	public IndexStoreActionHandler indexStoreActionHandler = new IndexStoreActionHandler();
	public IntegerNode integerNode = new IntegerNode();
	public InvType invType = new InvType();
	public ISAACCipher isaacCipher = new ISAACCipher();
	public Item item = new Item();
	public ItemComposition itemComposition = new ItemComposition();
	public ItemContainer itemContainer = new ItemContainer();
	public ItemLayer itemLayer = new ItemLayer();
	public IterableDualNodeQueue iterableDualNodeQueue = new IterableDualNodeQueue();
	public IterableHashTable iterableHashTable = new IterableHashTable();
	public JagexGame jagexGame = new JagexGame();
	public JagexLoginType jagexLoginType = new JagexLoginType();
	public KeyFocusListener keyFocusListener = new KeyFocusListener();
	public KitDefinition kitDefinition = new KitDefinition();
	public LoginPacket loginPacket = new LoginPacket();
	public MachineInfo machineInfo = new MachineInfo();
	public MainBufferProvider mainBufferProvider = new MainBufferProvider();
	public Mapping mapping = new Mapping();
	public MessageNode messageNode = new MessageNode();
	public MilliTimer milliTimer = new MilliTimer();
	public Model model = new Model();
	public ModelData modelData = new ModelData();
	public MouseInput mouseInput = new MouseInput();
	public MouseRecorder mouseRecorder = new MouseRecorder();
	public MouseWheelHandler mouseWheelHandler = new MouseWheelHandler();
	public NanoTimer nanoTimer = new NanoTimer();
	public NetWriter netWriter = new NetWriter();
	public Node node = new Node();
	public Node2LinkedList node2LinkedList = new Node2LinkedList();
	public NodeCache nodeCache = new NodeCache();
	public NPC npc = new NPC();
	public NPCComposition npcComposition = new NPCComposition();
	public ObjectComposition objectComposition = new ObjectComposition();
	public Occluder occluder = new Occluder();
	public Overlay overlay = new Overlay();
	public PacketBuffer packetBuffer = new PacketBuffer();
	public PacketNode packetNode = new PacketNode();
	public Parameters parameters = new Parameters();
	public PendingSpawn pendingSpawn = new PendingSpawn();
	public Player player = new Player(null);
	public PlayerComposition playerComposition = new PlayerComposition();
	public Preferences preferences = new Preferences();
	public Projectile projectile = new Projectile();
	public Rasterizer2D rasterizer2D = new Rasterizer2D();
	public Region region = new Region();
	public Renderable renderable = new Renderable();
	public RenderOverview renderOverview = new RenderOverview();
	public Residue residue = new Residue();
	public RSCanvas rsCanvas = new RSCanvas();
	public RunException runException = new RunException();
	public SceneTileModel sceneTileModel = new SceneTileModel();
	public SceneTilePaint sceneTilePaint = new SceneTilePaint();
	public Script script = new Script();
	public ScriptEvent scriptEvent = new ScriptEvent();
	public ScriptState scriptState = new ScriptState();
	public ScriptVarType scriptVarType = new ScriptVarType();
	public Sequence sequence = new Sequence();
	public Signlink signlink = new Signlink();
	public Size size = new Size();
	public SoundEffect soundEffect = new SoundEffect();
	public SoundEffect3 soundEffect3 = new SoundEffect3();
	public SoundTask soundTask = new SoundTask();
	public SourceDataSoundSystem sourceDataSoundSystem = new SourceDataSoundSystem();
	public Spotanim spotanim = new Spotanim();
	public SpritePixels spritePixels = new SpritePixels();
	public Task task = new Task();
	public Texture texture = new Texture();
	public TextureProvider textureProvider = new TextureProvider();
	public Tile tile = new Tile();
	public TotalQuantityComparator totalQuantityComparator = new TotalQuantityComparator();
	public UnitPriceComparator unitPriceComparator = new UnitPriceComparator();
	public UrlRequest urlRequest = new UrlRequest();
	public UrlRequester urlRequester = new UrlRequester();
	public Varbit varbit = new Varbit();
	public Varcs varcs = new Varcs();
	public VarPlayerType varPlayerType = new VarPlayerType();
	public VertexNormal vertexNormal = new VertexNormal();
	public WallObject wallObject = new WallObject();
	public Widget widget = new Widget();
	public WidgetNode widgetNode = new WidgetNode();
	public World world = new World();
	public WorldMapData worldMapData = new WorldMapData();
	

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
					rsClassCount++;
					Gson gson = new GsonBuilder().create();
					RSClass rsClass = gson.fromJson(reader, RSClass.class);
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
