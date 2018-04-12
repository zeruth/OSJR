package hooks.helpers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Map;

import game.Game;
import hooks.accessors.ChatLineBuffer;
import hooks.accessors.Client;
import hooks.accessors.MessageNode;
import paint.PaintListener;

public class MessageManager implements PaintListener {

	Map<Integer, Object> oldMap;

	public static final int SERVER = 0;
	public static final int PUBLIC = 2;
	public static final int HELP = 11; // ?
	public static final int CLAN = 9;

	public static ArrayList<MessageNode> publicMessages = new ArrayList<>();
	public static ArrayList<MessageNode> clanMessages = new ArrayList<>();
	public static ArrayList<MessageNode> serverMessages = new ArrayList<>();
	public static ArrayList<MessageNode> helpMessages = new ArrayList<>();
	public static ArrayList<MessageNode> unknownMessages = new ArrayList<>();

	public static void handleNewMessages() {
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
		if (m.get(HELP) != null) {
			ChatLineBuffer buffer = new ChatLineBuffer(m.get(HELP));
			for (MessageNode mn : buffer.getLines()) {
				if (mn.reference != null)
					if (!containsMessage(mn, helpMessages)) {
						handleNewHelpMessage(mn);
						helpMessages.add(mn);
					}
			}
		}
		int i = 0;
		while (i < 20) {
			if (i != HELP && i != SERVER && i != CLAN && i != PUBLIC) {
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
	}

	public static void handleNewClanMessage(MessageNode mn) {
		System.out.println("Clan: (" + mn.getName() + ") " + mn.getMessage());
	}

	public static void handleNewHelpMessage(MessageNode mn) {
		System.out.println("Help: " + mn.getMessage());
	}

	public static void handleNewUnknownMessage(MessageNode mn) {
		System.out.println("Unknown:" + mn.getType() + " " + mn.getMessage());
	}

	public static void testMessage() {
		System.out.println("New Message!");
	}

	@Override
	public void onRepaint(Graphics g) {
		handleNewMessages();
	}

}
