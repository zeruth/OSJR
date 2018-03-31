package os.rs.hooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import os.rs.hooks.accessors.Actor;
import os.rs.hooks.accessors.Area;
import os.rs.hooks.accessors.BaseVarType;
import os.rs.hooks.accessors.BoundingBox3D;
import os.rs.hooks.accessors.ChatLineBuffer;
import os.rs.hooks.accessors.Class160;
import os.rs.hooks.accessors.Class237;
import os.rs.hooks.accessors.Class308;
import os.rs.hooks.accessors.Class33;
import os.rs.hooks.accessors.Class38;
import os.rs.hooks.accessors.Class62;
import os.rs.hooks.accessors.Client;
import os.rs.hooks.accessors.ClientPacket;
import os.rs.hooks.accessors.Coordinates;
import os.rs.hooks.accessors.DecorativeObject;
import os.rs.hooks.accessors.GameEngine;
import os.rs.hooks.accessors.GameObject;
import os.rs.hooks.accessors.GroundObject;
import os.rs.hooks.accessors.Ignore;
import os.rs.hooks.accessors.Model;
import os.rs.hooks.accessors.Name;
import os.rs.hooks.accessors.Nameable;
import os.rs.hooks.accessors.Npc;
import os.rs.hooks.accessors.NpcComposition;
import os.rs.hooks.accessors.ObjectComposition;
import os.rs.hooks.accessors.PacketNode;
import os.rs.hooks.accessors.Player;
import os.rs.hooks.accessors.PlayerComposition;
import os.rs.hooks.accessors.Region;
import os.rs.hooks.accessors.Renderable;
import os.rs.hooks.accessors.Sequence;
import os.rs.hooks.accessors.SpritePixels;
import os.rs.hooks.accessors.Tile;
import os.rs.hooks.accessors.Varcs;
import os.rs.hooks.accessors.WallObject;
import os.rs.hooks.accessors.WorldComparator;
import os.rs.hooks.accessors.WorldMapData;
import os.rs.hooks.model.RSClass;

public class Hooks {

	public static Actor actor;

	public static Area area;
	public static BaseVarType baseVarType;
	public static BoundingBox3D boundingBox3D;
	public static ChatLineBuffer chatLineBuffer;
	public static Class160 class160;
	public static Class237 class237;
	public static Class308 class308;
	public static Class33 class33;
	public static Class38 class38;
	public static Class62 class62;
	public static Client client;
	public static ClientPacket clientPacket;
	public static Coordinates coordinates;
	public static DecorativeObject decorativeObject;
	public static GameEngine gameEngine;
	public static GameObject gameObject;
	public static GroundObject groundObject;
	public static Ignore ignore;
	public static Model model;
	public static Name name;
	public static Nameable nameable;
	public static Npc npc;
	public static NpcComposition npcComposition;
	public static ObjectComposition objectComposition;
	public static PacketNode packetNode;
	public static Player player;
	public static PlayerComposition playerComposition;
	public static Region region;
	public static Renderable renderable;
	public static Hooks selector;
	public static Sequence sequence;
	public static SpritePixels spritePixels;
	public static Tile tile;
	public static Varcs varcs;
	public static WallObject wallObject;
	public static WorldComparator worldComparator;
	public static WorldMapData worldMapData;

	public static void assignHook(RSClass c, String className) {
		RSClass temp = null;
		if (c != null)
			if (c.name.compareTo("Area") == 0) {
				area = new Area(null);
				temp = area;
			} else if (c.name.compareTo("Actor") == 0) {
				actor = new Actor(null);
				temp = actor;
			} else if (c.name.compareTo("BaseVarType") == 0) {
				baseVarType = new BaseVarType(null);
				temp = baseVarType;
			} else if (c.name.compareTo("BoundingBox3D") == 0) {
				boundingBox3D = new BoundingBox3D(null);
				temp = boundingBox3D;
			} else if (c.name.compareTo("class33") == 0) {
				class33 = new Class33(null);
				temp = class33;
			} else if (c.name.compareTo("class38") == 0) {
				class38 = new Class38(null);
				temp = class38;
			} else if (c.name.compareTo("class62") == 0) {
				class62 = new Class62(null);
				temp = class62;
			} else if (c.name.compareTo("class160") == 0) {
				class160 = new Class160(null);
				temp = class160;
			} else if (c.name.compareTo("class237") == 0) {
				class237 = new Class237(null);
				temp = class237;
			} else if (c.name.compareTo("class308") == 0) {
				class308 = new Class308(null);
				temp = class308;
			} else if (c.name.compareTo("ChatLineBuffer") == 0) {
				chatLineBuffer = new ChatLineBuffer(null);
				temp = chatLineBuffer;
			} else if (c.name.compareTo("Client") == 0) {
				temp = client;
			} else if (c.name.compareTo("ClientPacket") == 0) {
				clientPacket = new ClientPacket(null);
				temp = clientPacket;
			} else if (c.name.compareTo("Coordinates") == 0) {
				coordinates = new Coordinates(null);
				temp = coordinates;
			} else if (c.name.compareTo("DecorativeObject") == 0) {
				decorativeObject = new DecorativeObject(null);
				temp = decorativeObject;
			} else if (c.name.compareTo("GameEngine") == 0) {
				gameEngine = new GameEngine(null);
				temp = gameEngine;
			} else if (c.name.compareTo("GameObject") == 0) {
				gameObject = new GameObject(null);
				temp = gameObject;
			} else if (c.name.compareTo("GroundObject") == 0) {
				groundObject = new GroundObject(null);
				temp = groundObject;
			} else if (c.name.compareTo("Ignore") == 0) {
				ignore = new Ignore(null);
				temp = ignore;
			} else if (c.name.compareTo("Model") == 0) {
				model = new Model(null);
				temp = model;
			} else if (c.name.compareTo("Name") == 0) {
				name = new Name(null);
				temp = name;
			} else if (c.name.compareTo("Nameable") == 0) {
				nameable = new Nameable(null);
				temp = nameable;
			} else if (c.name.compareTo("NPC") == 0) {
				npc = new Npc(null);
				temp = npc;
			} else if (c.name.compareTo("NPCComposition") == 0) {
				npcComposition = new NpcComposition(null);
				temp = npcComposition;
			} else if (c.name.compareTo("ObjectComposition") == 0) {
				objectComposition = new ObjectComposition(null);
				temp = objectComposition;
			} else if (c.name.compareTo("PacketNode") == 0) {
				packetNode = new PacketNode(null);
				temp = packetNode;
			} else if (c.name.compareTo("Player") == 0) {
				player = new Player(null);
				temp = player;
			} else if (c.name.compareTo("PlayerComposition") == 0) {
				playerComposition = new PlayerComposition(null);
				temp = playerComposition;
			} else if (c.name.compareTo("Region") == 0) {
				region = new Region(null);
				temp = region;
			} else if (c.name.compareTo("Renderable") == 0) {
				renderable = new Renderable(null);
				temp = renderable;
			} else if (c.name.compareTo("Sequence") == 0) {
				sequence = new Sequence(null);
				temp = sequence;
			} else if (c.name.compareTo("SpritePixels") == 0) {
				spritePixels = new SpritePixels(null);
				temp = spritePixels;
			} else if (c.name.compareTo("Tile") == 0) {
				tile = new Tile(null);
				temp = tile;
			} else if (c.name.compareTo("Varcs") == 0) {
				varcs = new Varcs(null);
				temp = varcs;
			} else if (c.name.compareTo("WallObject") == 0) {
				wallObject = new WallObject(null);
				temp = wallObject;
			} else if (c.name.compareTo("WorldComparator") == 0) {
				worldComparator = new WorldComparator(null);
				temp = worldComparator;
			} else if (c.name.compareTo("WorldMapData") == 0) {
				worldMapData = new WorldMapData(null);
				temp = worldMapData;
			}

		if (temp != null) {
			temp.fields = c.fields;
			temp.name = c.name;
			temp.obfuscatedName = c.obfuscatedName;
			System.out.println("[OSRS] Loaded " + c.name + " Definition.");
		}

	}

	public static RSClass[] main() {
		Gson gson = new GsonBuilder().create();
		try {
			RSClass[] c = gson.fromJson(new FileReader(new File("./lib/Hooks.json")), RSClass[].class);
			return c;
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Hooks() {
		for (RSClass c : main()) {
			if (c != null)
				assignHook(c, c.name);
		}
	}

}
