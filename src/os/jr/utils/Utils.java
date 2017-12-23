package os.jr.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import os.jr.game.RSGame;
import os.jr.hooks.Hooks;
import os.jr.hooks.loader.RSClass;
import os.jr.ui.Updater;

public class Utils {

	public static int size;
	private static int[] XPforLevel = new int[128];

	public static void downloadGamePack() throws UnsupportedEncodingException, IOException {
		BufferedInputStream in = null;
		FileOutputStream out = null;
		try {
			URL url = RSGame.LIVE_JAR_URL;
			URLConnection conn = url.openConnection();
			size = conn.getContentLength();
			Updater.maximum = size;
			if (size < 0) {
				System.out.println("Could not get the file size");
			} else {
				System.out.println("\nGamepack update required.");
			}
			File file = new File(System.getProperty("user.home") + "/OSJR/");
			File file2 = new File(System.getProperty("user.home") + "/OSJR/gamepack.jar");
			file.mkdir();
			file2.createNewFile();
			in = new BufferedInputStream(url.openStream());
			out = new FileOutputStream(file2);
			byte[] data = new byte[1024];
			int count;
			double sumCount = 0.0;
			while ((count = in.read(data, 0, 1024)) != -1) {
				out.write(data, 0, count);
				sumCount += count;
				if (size > 0) {
					Updater.progress = (int) (sumCount);
				}
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e3) {
					e3.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e4) {
					e4.printStackTrace();
				}
			}
			SettingsIo.updateGamePackSize(size);
			Updater.downloadComplete = true;
		}
	}

	public static RSClass getClassbyName(String name) {

		if (name.compareTo("AbstractByteBuffer") == 0) {
			return Hooks.selector.abstractByteBuffer;
		} else if (name.compareTo("AbstractIntegerNode0") == 0) {
			return Hooks.selector.abstractIntegerNode0;
		} else if (name.compareTo("AbstractSoundSystem") == 0) {
			return Hooks.selector.abstractSoundSystem;
		} else if (name.compareTo("Actor") == 0) {
			return Hooks.selector.actor;
		} else if (name.compareTo("Area") == 0) {
			return Hooks.selector.area;
		} else if (name.compareTo("AttackOption") == 0) {
			return Hooks.selector.attackOption;
		} else if (name.compareTo("AudioEnvelope") == 0) {
			return Hooks.selector.audioEnvelope;
		} else if (name.compareTo("AudioInstrument") == 0) {
			return Hooks.selector.audioInstrument;
		} else if (name.compareTo("BaseVarType") == 0) {
			return Hooks.selector.baseVarType;
		} else if (name.compareTo("BoundingBox") == 0) {
			return Hooks.selector.boundingBox;
		} else if (name.compareTo("BoundingBox2D") == 0) {
			return Hooks.selector.boundingBox2D;
		} else if (name.compareTo("BoundingBox3D") == 0) {
			return Hooks.selector.boundingBox3D;
		} else if (name.compareTo("Bounds") == 0) {
			return Hooks.selector.bounds;
		} else if (name.compareTo("Buffer") == 0) {
			return Hooks.selector.buffer;
		} else if (name.compareTo("BufferProvider") == 0) {
			return Hooks.selector.bufferProvider;
		} else if (name.compareTo("BuildType") == 0) {
			return Hooks.selector.buildType;
		} else if (name.compareTo("ByteArrayNode") == 0) {
			return Hooks.selector.byteArrayNode;
		} else if (name.compareTo("CacheableNode") == 0) {
			return Hooks.selector.cacheableNode;
		} else if (name.compareTo("CacheFile") == 0) {
			return Hooks.selector.cacheFile;
		} else if (name.compareTo("ChatLineBuffer") == 0) {
			return Hooks.selector.chatLineBuffer;
		} else if (name.compareTo("ClanMember") == 0) {
			return Hooks.selector.clanMember;
		} else if (name.compareTo("ClassInfo") == 0) {
			return Hooks.selector.classInfo;
		} else if (name.compareTo("class0") == 0) {
			return Hooks.selector.class0;
		} else if (name.compareTo("class1") == 0) {
			return Hooks.selector.class1;
		} else if (name.compareTo("class101") == 0) {
			return Hooks.selector.class101;
		} else if (name.compareTo("class105") == 0) {
			return Hooks.selector.class105;
		} else if (name.compareTo("class106") == 0) {
			return Hooks.selector.class106;
		} else if (name.compareTo("class11") == 0) {
			return Hooks.selector.class11;
		} else if (name.compareTo("class111") == 0) {
			return Hooks.selector.class111;
		} else if (name.compareTo("class113") == 0) {
			return Hooks.selector.class113;
		} else if (name.compareTo("class115") == 0) {
			return Hooks.selector.class115;
		} else if (name.compareTo("class116") == 0) {
			return Hooks.selector.class116;
		} else if (name.compareTo("class133") == 0) {
			return Hooks.selector.class133;
		} else if (name.compareTo("class139") == 0) {
			return Hooks.selector.class139;
		} else if (name.compareTo("class150") == 0) {
			return Hooks.selector.class150;
		} else if (name.compareTo("class153") == 0) {
			return Hooks.selector.class153;
		} else if (name.compareTo("class157") == 0) {
			return Hooks.selector.class157;
		} else if (name.compareTo("class159") == 0) {
			return Hooks.selector.class159;
		} else if (name.compareTo("class160") == 0) {
			return Hooks.selector.class160;
		} else if (name.compareTo("class161") == 0) {
			return Hooks.selector.class161;
		} else if (name.compareTo("class163") == 0) {
			return Hooks.selector.class163;
		} else if (name.compareTo("class167") == 0) {
			return Hooks.selector.class167;
		} else if (name.compareTo("class168") == 0) {
			return Hooks.selector.class168;
		} else if (name.compareTo("class169") == 0) {
			return Hooks.selector.class169;
		} else if (name.compareTo("class173") == 0) {
			return Hooks.selector.class173;
		} else if (name.compareTo("class175") == 0) {
			return Hooks.selector.class175;
		} else if (name.compareTo("class178") == 0) {
			return Hooks.selector.class178;
		} else if (name.compareTo("class179") == 0) {
			return Hooks.selector.class179;
		} else if (name.compareTo("class18") == 0) {
			return Hooks.selector.class18;
		} else if (name.compareTo("class180") == 0) {
			return Hooks.selector.class180;
		} else if (name.compareTo("class185") == 0) {
			return Hooks.selector.class185;
		} else if (name.compareTo("class186") == 0) {
			return Hooks.selector.class186;
		} else if (name.compareTo("class188") == 0) {
			return Hooks.selector.class188;
		} else if (name.compareTo("class19") == 0) {
			return Hooks.selector.class19;
		} else if (name.compareTo("class192") == 0) {
			return Hooks.selector.class192;
		} else if (name.compareTo("class193") == 0) {
			return Hooks.selector.class193;
		} else if (name.compareTo("class194") == 0) {
			return Hooks.selector.class194;
		} else if (name.compareTo("class199") == 0) {
			return Hooks.selector.class199;
		} else if (name.compareTo("class2") == 0) {
			return Hooks.selector.class2;
		} else if (name.compareTo("class20") == 0) {
			return Hooks.selector.class20;
		} else if (name.compareTo("class21") == 0) {
			return Hooks.selector.class21;
		} else if (name.compareTo("class211") == 0) {
			return Hooks.selector.class211;
		} else if (name.compareTo("class213") == 0) {
			return Hooks.selector.class213;
		} else if (name.compareTo("class214") == 0) {
			return Hooks.selector.class214;
		} else if (name.compareTo("class215") == 0) {
			return Hooks.selector.class215;
		} else if (name.compareTo("class216") == 0) {
			return Hooks.selector.class216;
		} else if (name.compareTo("class217") == 0) {
			return Hooks.selector.class217;
		} else if (name.compareTo("class218") == 0) {
			return Hooks.selector.class218;
		} else if (name.compareTo("class219") == 0) {
			return Hooks.selector.class219;
		} else if (name.compareTo("class22") == 0) {
			return Hooks.selector.class22;
		} else if (name.compareTo("class221") == 0) {
			return Hooks.selector.class221;
		} else if (name.compareTo("class222") == 0) {
			return Hooks.selector.class222;
		} else if (name.compareTo("class225") == 0) {
			return Hooks.selector.class225;
		} else if (name.compareTo("class226") == 0) {
			return Hooks.selector.class226;
		} else if (name.compareTo("class228") == 0) {
			return Hooks.selector.class228;
		} else if (name.compareTo("class229") == 0) {
			return Hooks.selector.class229;
		} else if (name.compareTo("class23") == 0) {
			return Hooks.selector.class23;
		} else if (name.compareTo("class230") == 0) {
			return Hooks.selector.class230;
		} else if (name.compareTo("class231") == 0) {
			return Hooks.selector.class231;
		} else if (name.compareTo("class232") == 0) {
			return Hooks.selector.class232;
		} else if (name.compareTo("class233") == 0) {
			return Hooks.selector.class233;
		} else if (name.compareTo("class234") == 0) {
			return Hooks.selector.class234;
		} else if (name.compareTo("class236") == 0) {
			return Hooks.selector.class236;
		} else if (name.compareTo("class237") == 0) {
			return Hooks.selector.class237;
		} else if (name.compareTo("class238") == 0) {
			return Hooks.selector.class238;
		} else if (name.compareTo("class239") == 0) {
			return Hooks.selector.class239;
		} else if (name.compareTo("class240") == 0) {
			return Hooks.selector.class240;
		} else if (name.compareTo("class249") == 0) {
			return Hooks.selector.class249;
		} else if (name.compareTo("class25") == 0) {
			return Hooks.selector.class25;
		} else if (name.compareTo("class250") == 0) {
			return Hooks.selector.class250;
		} else if (name.compareTo("class254") == 0) {
			return Hooks.selector.class254;
		} else if (name.compareTo("class255") == 0) {
			return Hooks.selector.class255;
		} else if (name.compareTo("class260") == 0) {
			return Hooks.selector.class260;
		} else if (name.compareTo("class262") == 0) {
			return Hooks.selector.class262;
		} else if (name.compareTo("class263") == 0) {
			return Hooks.selector.class263;
		} else if (name.compareTo("class265") == 0) {
			return Hooks.selector.class265;
		} else if (name.compareTo("class268") == 0) {
			return Hooks.selector.class268;
		} else if (name.compareTo("class27") == 0) {
			return Hooks.selector.class27;
		} else if (name.compareTo("class276") == 0) {
			return Hooks.selector.class276;
		} else if (name.compareTo("class277") == 0) {
			return Hooks.selector.class277;
		} else if (name.compareTo("class278") == 0) {
			return Hooks.selector.class278;
		} else if (name.compareTo("class279") == 0) {
			return Hooks.selector.class279;
		} else if (name.compareTo("class28") == 0) {
			return Hooks.selector.class28;
		} else if (name.compareTo("class280") == 0) {
			return Hooks.selector.class280;
		} else if (name.compareTo("class281") == 0) {
			return Hooks.selector.class281;
		} else if (name.compareTo("class282") == 0) {
			return Hooks.selector.class282;
		} else if (name.compareTo("class283") == 0) {
			return Hooks.selector.class283;
		} else if (name.compareTo("class285") == 0) {
			return Hooks.selector.class285;
		} else if (name.compareTo("class287") == 0) {
			return Hooks.selector.class287;
		} else if (name.compareTo("class289") == 0) {
			return Hooks.selector.class289;
		} else if (name.compareTo("class29") == 0) {
			return Hooks.selector.class29;
		} else if (name.compareTo("class293") == 0) {
			return Hooks.selector.class293;
		} else if (name.compareTo("class296") == 0) {
			return Hooks.selector.class296;
		} else if (name.compareTo("class299") == 0) {
			return Hooks.selector.class299;
		} else if (name.compareTo("class3") == 0) {
			return Hooks.selector.class3;
		} else if (name.compareTo("class300") == 0) {
			return Hooks.selector.class300;
		} else if (name.compareTo("class305") == 0) {
			return Hooks.selector.class305;
		} else if (name.compareTo("class31") == 0) {
			return Hooks.selector.class31;
		} else if (name.compareTo("class33") == 0) {
			return Hooks.selector.class33;
		} else if (name.compareTo("class34") == 0) {
			return Hooks.selector.class34;
		} else if (name.compareTo("class35") == 0) {
			return Hooks.selector.class35;
		} else if (name.compareTo("class36") == 0) {
			return Hooks.selector.class36;
		} else if (name.compareTo("class37") == 0) {
			return Hooks.selector.class37;
		} else if (name.compareTo("class39") == 0) {
			return Hooks.selector.class39;
		} else if (name.compareTo("class40") == 0) {
			return Hooks.selector.class40;
		} else if (name.compareTo("class41") == 0) {
			return Hooks.selector.class41;
		} else if (name.compareTo("class43") == 0) {
			return Hooks.selector.class43;
		} else if (name.compareTo("class44") == 0) {
			return Hooks.selector.class44;
		} else if (name.compareTo("class45") == 0) {
			return Hooks.selector.class45;
		} else if (name.compareTo("class46") == 0) {
			return Hooks.selector.class46;
		} else if (name.compareTo("class47") == 0) {
			return Hooks.selector.class47;
		} else if (name.compareTo("class48") == 0) {
			return Hooks.selector.class48;
		} else if (name.compareTo("class5") == 0) {
			return Hooks.selector.class5;
		} else if (name.compareTo("class52") == 0) {
			return Hooks.selector.class52;
		} else if (name.compareTo("class54") == 0) {
			return Hooks.selector.class54;
		} else if (name.compareTo("class56") == 0) {
			return Hooks.selector.class56;
		} else if (name.compareTo("class60") == 0) {
			return Hooks.selector.class60;
		} else if (name.compareTo("class61") == 0) {
			return Hooks.selector.class61;
		} else if (name.compareTo("class64") == 0) {
			return Hooks.selector.class64;
		} else if (name.compareTo("class7") == 0) {
			return Hooks.selector.class7;
		} else if (name.compareTo("class72") == 0) {
			return Hooks.selector.class72;
		} else if (name.compareTo("class81") == 0) {
			return Hooks.selector.class81;
		} else if (name.compareTo("class82") == 0) {
			return Hooks.selector.class82;
		} else if (name.compareTo("class86") == 0) {
			return Hooks.selector.class86;
		} else if (name.compareTo("class87") == 0) {
			return Hooks.selector.class87;
		} else if (name.compareTo("class89") == 0) {
			return Hooks.selector.class89;
		} else if (name.compareTo("class91") == 0) {
			return Hooks.selector.class91;
		} else if (name.compareTo("class94") == 0) {
			return Hooks.selector.class94;
		} else if (name.compareTo("class96") == 0) {
			return Hooks.selector.class96;
		} else if (name.compareTo("Client") == 0) {
			return Hooks.selector.client;
		} else if (name.compareTo("ClientPacket") == 0) {
			return Hooks.selector.clientPacket;
		} else if (name.compareTo("CodeBook") == 0) {
			return Hooks.selector.codeBook;
		} else if (name.compareTo("CollisionData") == 0) {
			return Hooks.selector.collisionData;
		} else if (name.compareTo("CombatInfo1") == 0) {
			return Hooks.selector.combatInfo1;
		} else if (name.compareTo("CombatInfo2") == 0) {
			return Hooks.selector.combatInfo2;
		} else if (name.compareTo("CombatInfoList") == 0) {
			return Hooks.selector.combatInfoList;
		} else if (name.compareTo("CombatInfoListHolder") == 0) {
			return Hooks.selector.combatInfoListHolder;
		} else if (name.compareTo("ContextMenuRow") == 0) {
			return Hooks.selector.contextMenuRow;
		} else if (name.compareTo("Coordinates") == 0) {
			return Hooks.selector.coordinates;
		} else if (name.compareTo("DecorativeObject") == 0) {
			return Hooks.selector.decorativeObject;
		} else if (name.compareTo("Deque") == 0) {
			return Hooks.selector.deque;
		} else if (name.compareTo("DirectByteBuffer") == 0) {
			return Hooks.selector.directByteBuffer;
		} else if (name.compareTo("DState") == 0) {
			return Hooks.selector.dState;
		} else if (name.compareTo("DynamicObject") == 0) {
			return Hooks.selector.dynamicObject;
		} else if (name.compareTo("Enum") == 0) {
			return Hooks.selector.enum_;
		} else if (name.compareTo("Enumerated") == 0) {
			return Hooks.selector.enumerated;
		} else if (name.compareTo("FaceNormal") == 0) {
			return Hooks.selector.faceNormal;
		} else if (name.compareTo("FileOnDisk") == 0) {
			return Hooks.selector.fileOnDisk;
		} else if (name.compareTo("FileRequest") == 0) {
			return Hooks.selector.fileRequest;
		} else if (name.compareTo("FileSystem") == 0) {
			return Hooks.selector.fileSystem;
		} else if (name.compareTo("Floor1") == 0) {
			return Hooks.selector.floor1;
		} else if (name.compareTo("FloorUnderlayDefinition") == 0) {
			return Hooks.selector.floorUnderlayDefinition;
		} else if (name.compareTo("Font") == 0) {
			return Hooks.selector.font;
		} else if (name.compareTo("FontName") == 0) {
			return Hooks.selector.fontName;
		} else if (name.compareTo("Fonts") == 0) {
			return Hooks.selector.fonts;
		} else if (name.compareTo("FontTypeFace") == 0) {
			return Hooks.selector.fontTypeFace;
		} else if (name.compareTo("Frame") == 0) {
			return Hooks.selector.frame;
		} else if (name.compareTo("FrameMap") == 0) {
			return Hooks.selector.frameMap;
		} else if (name.compareTo("Frames") == 0) {
			return Hooks.selector.frames;
		} else if (name.compareTo("Friend") == 0) {
			return Hooks.selector.friend;
		} else if (name.compareTo("FriendLoginUpdate") == 0) {
			return Hooks.selector.friendLoginUpdate;
		} else if (name.compareTo("GameEngine") == 0) {
			return Hooks.selector.gameEngine;
		} else if (name.compareTo("GameObject") == 0) {
			return Hooks.selector.gameObject;
		} else if (name.compareTo("GrandExchangeEvent") == 0) {
			return Hooks.selector.grandExchangeEvent;
		} else if (name.compareTo("GrandExchangeEvents") == 0) {
			return Hooks.selector.grandExchangeEvents;
		} else if (name.compareTo("GrandExchangeOffer") == 0) {
			return Hooks.selector.grandExchangeOffer;
		} else if (name.compareTo("Graphics3D") == 0) {
			return Hooks.selector.graphics3D;
		} else if (name.compareTo("GraphicsObject") == 0) {
			return Hooks.selector.graphicsObject;
		} else if (name.compareTo("GroundObject") == 0) {
			return Hooks.selector.groundObject;
		} else if (name.compareTo("GZipDecompressor") == 0) {
			return Hooks.selector.gzipDecompressor;
		} else if (name.compareTo("HashTable") == 0) {
			return Hooks.selector.hashTable;
		} else if (name.compareTo("HashTableIterator") == 0) {
			return Hooks.selector.hashTableIterator;
		} else if (name.compareTo("Huffman") == 0) {
			return Hooks.selector.huffman;
		} else if (name.compareTo("Identifiers") == 0) {
			return Hooks.selector.identifiers;
		} else if (name.compareTo("Ignore") == 0) {
			return Hooks.selector.ignore;
		} else if (name.compareTo("IndexData") == 0) {
			return Hooks.selector.indexData;
		} else if (name.compareTo("IndexDataBase") == 0) {
			return Hooks.selector.indexDataBase;
		} else if (name.compareTo("IndexedSprite") == 0) {
			return Hooks.selector.indexedSprite;
		} else if (name.compareTo("IndexFile") == 0) {
			return Hooks.selector.indexFile;
		} else if (name.compareTo("IndexStoreActionHandler") == 0) {
			return Hooks.selector.indexStoreActionHandler;
		} else if (name.compareTo("IntegerNode") == 0) {
			return Hooks.selector.integerNode;
		} else if (name.compareTo("InvType") == 0) {
			return Hooks.selector.invType;
		} else if (name.compareTo("ISAACCipher") == 0) {
			return Hooks.selector.isaacCipher;
		} else if (name.compareTo("Item") == 0) {
			return Hooks.selector.item;
		} else if (name.compareTo("ItemComposition") == 0) {
			return Hooks.selector.itemComposition;
		} else if (name.compareTo("ItemContainer") == 0) {
			return Hooks.selector.itemContainer;
		} else if (name.compareTo("ItemLayer") == 0) {
			return Hooks.selector.itemLayer;
		} else if (name.compareTo("IterableDualNodeQueue") == 0) {
			return Hooks.selector.iterableDualNodeQueue;
		} else if (name.compareTo("IterableHashTable") == 0) {
			return Hooks.selector.iterableHashTable;
		} else if (name.compareTo("ITextureLoader") == 0) {
			return Hooks.selector.iTextureLoader;
		} else if (name.compareTo("JagexGame") == 0) {
			return Hooks.selector.jagexGame;
		} else if (name.compareTo("JagexLoginType") == 0) {
			return Hooks.selector.jagexLoginType;
		} else if (name.compareTo("KeyFocusListener") == 0) {
			return Hooks.selector.keyFocusListener;
		} else if (name.compareTo("KitDefinition") == 0) {
			return Hooks.selector.kitDefinition;
		} else if (name.compareTo("Link") == 0) {
			return Hooks.selector.link;
		} else if (name.compareTo("LinkDeque") == 0) {
			return Hooks.selector.linkDeque;
		} else if (name.compareTo("LoginPacket") == 0) {
			return Hooks.selector.loginPacket;
		} else if (name.compareTo("MachineInfo") == 0) {
			return Hooks.selector.machineInfo;
		} else if (name.compareTo("MainBufferProvider") == 0) {
			return Hooks.selector.mainBufferProvider;
		} else if (name.compareTo("Mapping") == 0) {
			return Hooks.selector.mapping;
		} else if (name.compareTo("MessageNode") == 0) {
			return Hooks.selector.messageNode;
		} else if (name.compareTo("MilliTimer") == 0) {
			return Hooks.selector.milliTimer;
		} else if (name.compareTo("Model") == 0) {
			return Hooks.selector.model;
		} else if (name.compareTo("ModelData") == 0) {
			return Hooks.selector.modelData;
		} else if (name.compareTo("MouseInput") == 0) {
			return Hooks.selector.mouseInput;
		} else if (name.compareTo("MouseRecorder") == 0) {
			return Hooks.selector.mouseRecorder;
		} else if (name.compareTo("MouseWheel") == 0) {
			return Hooks.selector.mouseWheel;
		} else if (name.compareTo("MouseWheelHandler") == 0) {
			return Hooks.selector.mouseWheelHandler;
		} else if (name.compareTo("NanoTimer") == 0) {
			return Hooks.selector.nanoTimer;
		} else if (name.compareTo("NetWriter") == 0) {
			return Hooks.selector.netWriter;
		} else if (name.compareTo("Node") == 0) {
			return Hooks.selector.node;
		} else if (name.compareTo("Node2LinkedList") == 0) {
			return Hooks.selector.node2LinkedList;
		} else if (name.compareTo("NodeCache") == 0) {
			return Hooks.selector.nodeCache;
		} else if (name.compareTo("NPC") == 0) {
			return Hooks.selector.npc;
		} else if (name.compareTo("NPCComposition") == 0) {
			return Hooks.selector.npcComposition;
		} else if (name.compareTo("ObjectNode") == 0) {
			return Hooks.selector.objectNode;
		} else if (name.compareTo("ObjectComposition") == 0) {
			return Hooks.selector.objectComposition;
		} else if (name.compareTo("Occluder") == 0) {
			return Hooks.selector.occluder;
		} else if (name.compareTo("Overlay") == 0) {
			return Hooks.selector.overlay;
		} else if (name.compareTo("OwnWorldComparator") == 0) {
			return Hooks.selector.ownWorldComparator;
		} else if (name.compareTo("PacketBuffer") == 0) {
			return Hooks.selector.packetBuffer;
		} else if (name.compareTo("PacketNode") == 0) {
			return Hooks.selector.packetNode;
		} else if (name.compareTo("Parameters") == 0) {
			return Hooks.selector.parameters;
		} else if (name.compareTo("PendingSpawn") == 0) {
			return Hooks.selector.pendingSpawn;
		} else if (name.compareTo("Permission") == 0) {
			return Hooks.selector.permission;
		} else if (name.compareTo("Player") == 0) {
			return Hooks.selector.player;
		} else if (name.compareTo("PlayerComposition") == 0) {
			return Hooks.selector.playerComposition;
		} else if (name.compareTo("Preferences") == 0) {
			return Hooks.selector.preferences;
		} else if (name.compareTo("Projectile") == 0) {
			return Hooks.selector.projectile;
		} else if (name.compareTo("Rasterizer2D") == 0) {
			return Hooks.selector.rasterizer2D;
		} else if (name.compareTo("Region") == 0) {
			return Hooks.selector.region;
		} else if (name.compareTo("Renderable") == 0) {
			return Hooks.selector.renderable;
		} else if (name.compareTo("RenderOverview") == 0) {
			return Hooks.selector.renderOverview;
		} else if (name.compareTo("Residue") == 0) {
			return Hooks.selector.residue;
		} else if (name.compareTo("RSCanvas") == 0) {
			return Hooks.selector.rsCanvas;
		} else if (name.compareTo("RSSocket") == 0) {
			return Hooks.selector.rsSocket;
		} else if (name.compareTo("RunException") == 0) {
			return Hooks.selector.runException;
		} else if (name.compareTo("SceneTileModel") == 0) {
			return Hooks.selector.sceneTileModel;
		} else if (name.compareTo("SceneTilePaint") == 0) {
			return Hooks.selector.sceneTilePaint;
		} else if (name.compareTo("Script") == 0) {
			return Hooks.selector.script;
		} else if (name.compareTo("ScriptEvent") == 0) {
			return Hooks.selector.scriptEvent;
		} else if (name.compareTo("ScriptState") == 0) {
			return Hooks.selector.scriptState;
		} else if (name.compareTo("ScriptVarType") == 0) {
			return Hooks.selector.scriptVarType;
		} else if (name.compareTo("Sequence") == 0) {
			return Hooks.selector.sequence;
		} else if (name.compareTo("ServerPacket") == 0) {
			return Hooks.selector.serverPacket;
		} else if (name.compareTo("Signlink") == 0) {
			return Hooks.selector.signlink;
		} else if (name.compareTo("Size") == 0) {
			return Hooks.selector.size;
		} else if (name.compareTo("SoundEffect") == 0) {
			return Hooks.selector.soundEffect;
		} else if (name.compareTo("SoundEffect3") == 0) {
			return Hooks.selector.soundEffect3;
		} else if (name.compareTo("SoundTask") == 0) {
			return Hooks.selector.soundTask;
		} else if (name.compareTo("SoundTaskDataProvider") == 0) {
			return Hooks.selector.soundTaskDataProvider;
		} else if (name.compareTo("SourceDataSoundSystem") == 0) {
			return Hooks.selector.sourceDataSoundSystem;
		} else if (name.compareTo("Spotanim") == 0) {
			return Hooks.selector.spotanim;
		} else if (name.compareTo("SpritePixels") == 0) {
			return Hooks.selector.spritePixels;
		} else if (name.compareTo("Task") == 0) {
			return Hooks.selector.task;
		} else if (name.compareTo("TaskDataNode") == 0) {
			return Hooks.selector.taskDataNode;
		} else if (name.compareTo("TaskDataProvider") == 0) {
			return Hooks.selector.taskDataProvider;
		} else if (name.compareTo("Texture") == 0) {
			return Hooks.selector.texture;
		} else if (name.compareTo("TextureProvider") == 0) {
			return Hooks.selector.textureProvider;
		} else if (name.compareTo("Tile") == 0) {
			return Hooks.selector.tile;
		} else if (name.compareTo("Timer") == 0) {
			return Hooks.selector.timer;
		} else if (name.compareTo("TotalQuantityComparator") == 0) {
			return Hooks.selector.totalQuantityComparator;
		} else if (name.compareTo("Track1") == 0) {
			return Hooks.selector.track1;
		} else if (name.compareTo("UnitPriceComparator") == 0) {
			return Hooks.selector.unitPriceComparator;
		} else if (name.compareTo("UrlRequest") == 0) {
			return Hooks.selector.urlRequest;
		} else if (name.compareTo("UrlRequester") == 0) {
			return Hooks.selector.urlRequester;
		} else if (name.compareTo("Varbit") == 0) {
			return Hooks.selector.varbit;
		} else if (name.compareTo("Varcs") == 0) {
			return Hooks.selector.varcs;
		} else if (name.compareTo("VarPlayerType") == 0) {
			return Hooks.selector.varPlayerType;
		} else if (name.compareTo("VertexNormal") == 0) {
			return Hooks.selector.vertexNormal;
		} else if (name.compareTo("WallObject") == 0) {
			return Hooks.selector.wallObject;
		} else if (name.compareTo("Widget") == 0) {
			return Hooks.selector.widget;
		} else if (name.compareTo("WidgetNode") == 0) {
			return Hooks.selector.widgetNode;
		} else if (name.compareTo("World") == 0) {
			return Hooks.selector.world;
		} else if (name.compareTo("WorldComparator") == 0) {
			return Hooks.selector.worldComparator;
		} else if (name.compareTo("WorldMapData") == 0) {
			return Hooks.selector.worldMapData;
		} else if (name.compareTo("WorldMapSectionBase") == 0) {
			return Hooks.selector.worldMapSectionBase;
		} else if (name.compareTo("WorldMapType1") == 0) {
			return Hooks.selector.worldMapType1;
		} else if (name.compareTo("WorldMapType2") == 0) {
			return Hooks.selector.worldMapType2;
		} else if (name.compareTo("WorldMapType3") == 0) {
			return Hooks.selector.worldMapType3;
		}

		System.out.println(name+" not loaded.");
		return null;
	}

	/**
	 * getFileSize - Gets filesize of a given URL.
	 * 
	 * @param url
	 *            = URL to be sized.
	 * @return = filesize.
	 */
	public static int getFileSize(URL url) {
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("HEAD");
			conn.getInputStream();
			return conn.getContentLength();
		} catch (IOException e) {
			return -1;
		} finally {
			conn.disconnect();
		}
	}

	public static String getParamName(String param) {
		try {
			int startIndex = param.indexOf("<param name=\"") + 13;
			int endIndex = param.indexOf("\" value");
			return param.substring(startIndex, endIndex);
		} catch (StringIndexOutOfBoundsException e) {
			int startIndex = param.indexOf("<param name=") + 12;
			int endIndex = param.indexOf(" value");
			return param.substring(startIndex, endIndex);
		}
	}

	/**
	 * getParamValue - Gets parameter's value.
	 * 
	 * @param param
	 *            - Parameter's identifier.
	 * @return = parameter.
	 */
	public static String getParamValue(String param) {
		try {
			int startIndex = param.indexOf("value=\"") + 7;
			int endIndex = param.indexOf("\">');");
			return param.substring(startIndex, endIndex);
		} catch (StringIndexOutOfBoundsException e) {
			int startIndex = param.indexOf("value=") + 6;
			int endIndex = param.indexOf(">');");
			return param.substring(startIndex, endIndex);
		}
	}

	public static String getUTCTime() {
		LocalDateTime ldt1 = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
		String second = "" + ldt1.getSecond();
		String minute = "" + ldt1.getMinute();
		String hour = "" + ldt1.getHour();

		if (Integer.valueOf(second) < 10) {
			second = "0" + second;
		}
		if (Integer.valueOf(minute) < 10) {
			minute = "0" + minute;
		}
		if (Integer.valueOf(hour) < 10) {
			hour = "0" + hour;
		}
		return hour + ":" + minute + ":" + second + " UTC";
	}

	public static int getXPforCurrentLevel(int currentLevel) {
		return XPforLevel[currentLevel];
	}

	public static int getXPforNextLevel(int currentLevel) {
		return XPforLevel[currentLevel + 1];
	}

	public static int localGamePackSize() {
		File file = new File(System.getProperty("user.home") + "/OSJR/gamepack.jar");
		return (int) file.length();
	}

	public static void makeXPforLevel() {
		XPforLevel[1] = 0;
		XPforLevel[2] = 83;
		XPforLevel[3] = 174;
		XPforLevel[4] = 276;
		XPforLevel[5] = 388;
		XPforLevel[6] = 512;
		XPforLevel[7] = 650;
		XPforLevel[8] = 801;
		XPforLevel[9] = 969;
		XPforLevel[10] = 1154;
		XPforLevel[11] = 1358;
		XPforLevel[12] = 1584;
		XPforLevel[13] = 1833;
		XPforLevel[14] = 2107;
		XPforLevel[15] = 2411;
		XPforLevel[16] = 2746;
		XPforLevel[17] = 3115;
		XPforLevel[18] = 3523;
		XPforLevel[19] = 3973;
		XPforLevel[20] = 4470;
		XPforLevel[21] = 5018;
		XPforLevel[22] = 5624;
		XPforLevel[23] = 6291;
		XPforLevel[24] = 7028;
		XPforLevel[25] = 7842;
		XPforLevel[26] = 8740;
		XPforLevel[27] = 9730;
		XPforLevel[28] = 10824;
		XPforLevel[29] = 12031;
		XPforLevel[30] = 13363;
		XPforLevel[31] = 14833;
		XPforLevel[32] = 16456;
		XPforLevel[33] = 18247;
		XPforLevel[34] = 20224;
		XPforLevel[35] = 22406;
		XPforLevel[36] = 24815;
		XPforLevel[37] = 27473;
		XPforLevel[38] = 30408;
		XPforLevel[39] = 33648;
		XPforLevel[40] = 37224;
		XPforLevel[41] = 41171;
		XPforLevel[42] = 45529;
		XPforLevel[43] = 50339;
		XPforLevel[44] = 55649;
		XPforLevel[45] = 61512;
		XPforLevel[46] = 67983;
		XPforLevel[47] = 75127;
		XPforLevel[48] = 83014;
		XPforLevel[49] = 91721;
		XPforLevel[50] = 101333;
		XPforLevel[51] = 111945;
		XPforLevel[52] = 123660;
		XPforLevel[53] = 136594;
		XPforLevel[54] = 150872;
		XPforLevel[55] = 166636;
		XPforLevel[56] = 184040;
		XPforLevel[57] = 203254;
		XPforLevel[58] = 224466;
		XPforLevel[59] = 247886;
		XPforLevel[60] = 273742;
		XPforLevel[61] = 302288;
		XPforLevel[62] = 333804;
		XPforLevel[63] = 368599;
		XPforLevel[64] = 407015;
		XPforLevel[65] = 449428;
		XPforLevel[66] = 496254;
		XPforLevel[67] = 547953;
		XPforLevel[68] = 605032;
		XPforLevel[69] = 668051;
		XPforLevel[70] = 737627;
		XPforLevel[71] = 814445;
		XPforLevel[72] = 899257;
		XPforLevel[73] = 992895;
		XPforLevel[74] = 1096278;
		XPforLevel[75] = 1210421;
		XPforLevel[76] = 1336443;
		XPforLevel[77] = 1475581;
		XPforLevel[78] = 1629200;
		XPforLevel[79] = 1798808;
		XPforLevel[80] = 1986068;
		XPforLevel[81] = 2192818;
		XPforLevel[82] = 2421087;
		XPforLevel[83] = 2673114;
		XPforLevel[84] = 2951373;
		XPforLevel[85] = 3258594;
		XPforLevel[86] = 3597792;
		XPforLevel[87] = 3972294;
		XPforLevel[88] = 4385776;
		XPforLevel[89] = 4842295;
		XPforLevel[90] = 5346332;
		XPforLevel[91] = 5902831;
		XPforLevel[92] = 6517253;
		XPforLevel[93] = 7195629;
		XPforLevel[94] = 7994614;
		XPforLevel[95] = 8771558;
		XPforLevel[96] = 9684577;
		XPforLevel[97] = 10692629;
		XPforLevel[98] = 11805606;
		XPforLevel[99] = 13034431;
		XPforLevel[100] = 14391160;
		XPforLevel[101] = 15889109;
		XPforLevel[102] = 17542976;
		XPforLevel[103] = 19368992;
		XPforLevel[104] = 21385073;
		XPforLevel[105] = 23611006;
		XPforLevel[106] = 23068632;
		XPforLevel[107] = 28782069;
		XPforLevel[108] = 31777943;
		XPforLevel[109] = 35085654;
		XPforLevel[110] = 38737661;
		XPforLevel[111] = 42769801;
		XPforLevel[112] = 47221641;
		XPforLevel[113] = 52136869;
		XPforLevel[114] = 57563718;
		XPforLevel[115] = 63555443;
		XPforLevel[116] = 70170840;
		XPforLevel[117] = 77474828;
		XPforLevel[118] = 85539082;
		XPforLevel[119] = 94442737;
		XPforLevel[120] = 104273167;
		XPforLevel[121] = 115126838;
		XPforLevel[122] = 127110260;
		XPforLevel[123] = 140341028;
		XPforLevel[124] = 154948977;
		XPforLevel[125] = 171077457;
		XPforLevel[126] = 188884740;
		XPforLevel[127] = 200000000;
	}

	public static void sendDebugPrintln(String text) {
		System.out.println("[OSJR] " + text);
	}

}
