package cache;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Map;

import game.Game;
import hooks.accessors.ChatLineBuffer;
import hooks.accessors.Client;
import hooks.accessors.MessageNode;
import paint.PaintListener;

public class MessageManager implements PaintListener {
	
	static int tick = 0;

	public static final int SERVER = 0;
	public static final int PUBLIC = 2;
	public static final int PM_RECEIVED = 3;
	public static final int TRADE_RECEIVED = 4;
	public static final int PM_INFO = 5;
	public static final int PM_SENT = 6;
	public static final int PM_RECEIVED_MOD = 7;
	public static final int CLAN = 9;
	public static final int CLAN_INFO = 11;
	public static final int TRADE_SENT = 12;
	public static final int ABUSE_REPORT = 26;
	public static final int EXAMINE_ITEM = 27;
	public static final int EXAMINE_NPC = 28;
	public static final int EXAMINE_OBJECT = 29;
	public static final int FRIENDS_ADD = 30;
	public static final int IGNORE_ADD = 31;
	public static final int AUTOCHAT = 90;
	public static final int GAME = 99;
	public static final int TRADE = 101;
	public static final int DUEL = 103;
	public static final int FILTERED = 105;
	public static final int ACTION = 109;

	public static ArrayList<MessageNode> publicMessages = new ArrayList<>();
	public static ArrayList<MessageNode> clanMessages = new ArrayList<>();
	public static ArrayList<MessageNode> serverMessages = new ArrayList<>();
	public static ArrayList<MessageNode> helpMessages = new ArrayList<>();
	public static ArrayList<MessageNode> filteredMessages = new ArrayList<>();
	public static ArrayList<MessageNode> unknownMessages = new ArrayList<>();

	public static void handleNewMessages() {
		if (tick>40) {
			Map<Integer, Object> m = Client.getChatLineMap();
			if (m.get(SERVER) != null) {
				ChatLineBuffer buffer = new ChatLineBuffer(m.get(SERVER));
				for (MessageNode mn : buffer.getLines()) {
					if (mn.reference != null)
						if (!containsMessage(mn, serverMessages)) {
							handleNewServerMessage(mn);
							serverMessages.add(mn);
						}
				}
			}
			if (m.get(PUBLIC) != null) {
				ChatLineBuffer buffer = new ChatLineBuffer(m.get(PUBLIC));
				for (MessageNode mn : buffer.getLines()) {
					if (mn.reference != null)
						if (!containsMessage(mn, publicMessages)) {
							if (mn.getMessage().contains("lol42")) {
								Game.sendTrayMessage("test", "succeeded");
							}
							handleNewPublicMessage(mn);
							publicMessages.add(mn);
						}
				}
			}
			if (m.get(CLAN) != null) {
				ChatLineBuffer buffer = new ChatLineBuffer(m.get(CLAN));
				for (MessageNode mn : buffer.getLines()) {
					if (mn.reference != null)
						if (!containsMessage(mn, clanMessages)) {
							handleNewClanMessage(mn);
							clanMessages.add(mn);
						}
				}
			}
			if (m.get(CLAN_INFO) != null) {
				ChatLineBuffer buffer = new ChatLineBuffer(m.get(CLAN_INFO));
				for (MessageNode mn : buffer.getLines()) {
					if (mn.reference != null)
						if (!containsMessage(mn, helpMessages)) {
							handleNewClanInfoMessage(mn);
							helpMessages.add(mn);
						}
				}
			}
			if (m.get(FILTERED) != null) {
				ChatLineBuffer buffer = new ChatLineBuffer(m.get(FILTERED));
				for (MessageNode mn : buffer.getLines()) {
					if (mn.reference != null)
						if (!containsMessage(mn, filteredMessages)) {
							handleNewFilteredMessage(mn);
							filteredMessages.add(mn);
						}
				}
			}
			int i = 0;
			while (i < 110) {
				if (i != CLAN_INFO && i != SERVER && i != CLAN && i != PUBLIC && i!=FILTERED) {
					if (m.get(i) != null) {
						ChatLineBuffer buffer = new ChatLineBuffer(m.get(i));
						for (MessageNode mn : buffer.getLines()) {
							if (mn.reference != null)
								if (!containsMessage(mn, unknownMessages)) {
									handleNewUnknownMessage(mn);
									unknownMessages.add(mn);
								}
						}
					}
				}
				i++;
			}
			tick=0;
		} else {
			tick++;
		}
		
	}

	public static boolean containsMessage(MessageNode newMessage, ArrayList<MessageNode> messages) {
		for (MessageNode m : messages) {
			if (newMessage != null)
				if (newMessage.getMessage().compareTo(m.getMessage()) == 0) {
					if (newMessage.getTick() == m.getTick())
						return true;
				}
		}
		return false;
	}

	public static void handleNewPublicMessage(MessageNode mn) {
		System.out.println("Public: (" + mn.getName() + ") " + mn.getMessage());
	}

	public static void handleNewServerMessage(MessageNode mn) {
		System.out.println("Server: " + mn.getMessage());
		if (mn.getMessage().contains("A bird's nest falls out of the tree."))
			Game.sendTrayMessage("OSJR", "A bird's nest falls out of the tree.");
		if (mn.getMessage().contains("Welcome to RuneScape."))
			Client.loggedIn = true;
	}

	public static void handleNewClanMessage(MessageNode mn) {
		System.out.println("Clan: (" + mn.getName() + ") " + mn.getMessage());
	}

	public static void handleNewClanInfoMessage(MessageNode mn) {
		System.out.println("Help: " + mn.getMessage());
	}

	public static void handleNewUnknownMessage(MessageNode mn) {
		System.out.println("Unknown:" + mn.getType() + " " + mn.getMessage());
	}

	public static void handleNewFilteredMessage(MessageNode mn) {
		if (Game.debug)
		System.out.println("Filtered: " + mn.getMessage());
	}

	public static void testMessage() {
		System.out.println("New Message!");
	}

	@Override
	public void onRepaint(Graphics g) {
		handleNewMessages();
	}

}
