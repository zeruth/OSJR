package os.jr.hooks;

import os.jr.boot.Boot;

public class Hooks {
	
	public static Hooks selector;
	
	public Actor actor = new Actor();
	public AnimableNode animableNode = new AnimableNode();
	public AnimationSequence animationSequence = new AnimationSequence();
	public BoundaryObject boundaryObject = new BoundaryObject();
	public Buffer buffer = new Buffer();
	public BufferedConnection bufferedconnection = new BufferedConnection();
	public Cache cache = new Cache();
	public Cacheable cacheable = new Cacheable();
	public ClassData classData = new ClassData();
	public Client client = new Client(Boot.rootReference);
	public CollisionMap collisionMap = new CollisionMap();
	public CombatInfo1 combatInfo1 = new CombatInfo1();
	public CombatInfo2 combatInfo2 = new CombatInfo2();
	public CombatInfoHolder combatInfoHolder = new CombatInfoHolder();
	public CombatInfoList combatInfoList = new CombatInfoList();
	public FloorDecoration floorDecoration = new FloorDecoration();
	public GameObject gameObject = new GameObject();
	public GameShell gameShell = new GameShell();
	public GrandExchange grandExchange = new GrandExchange();
	public HashTable hashTable = new HashTable();
	public ImageRGB imageRGB = new ImageRGB();
	public IndexedRGB indexedRGB = new IndexedRGB();
	public Item item = new Item();
	public Keyboard keyboard = new Keyboard();
	public LinkedList linkedList = new LinkedList();
	public Model model = new Model();
	public Node node = new Node();
	public NodeDeque nodeDeque = new NodeDeque();
	public NPC npc = new NPC();
	public Player player = new Player();
	public PlayerDefinition playerDefinition = new PlayerDefinition();
	public Queue queue = new Queue();
	public Rasteriser rasteriser = new Rasteriser();
	public Rasteriser3D rasteriser3d = new Rasteriser3D();
	public Region region = new Region();
	public Renderable renderable = new Renderable();
	public SceneTile sceneTile = new SceneTile();
	public Typeface typeface = new Typeface();
	public WallDecoration wallDecoration = new WallDecoration();
	public Widget widget = new Widget();
	public WidgetNode widgetNode = new WidgetNode();
	
	
	public static void init() {
		selector = new Hooks();
	}

}
