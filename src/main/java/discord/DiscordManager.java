package discord;

import hooks.Hooks;

public class DiscordManager {

	public static String discordStatus = "Main Menu";

	public static boolean loggedIn = false;

	public static long start = System.currentTimeMillis() / 1000L;

	public static Thread t = new Thread(new Runnable() {

		@Override
		public void run() {
			while (true != false) {
				// TODO Auto-generated method stub
				String applicationId = "" + 429263064676958218L;
				DiscordRpc discordRpc = new DiscordRpc();

				DiscordEventHandler discordEventHandler = new DiscordEventHandler() {
					@Override
					public void disconnected(ErrorCode errorCode, String message) {
						// System.err.println("CLASS DISCONNECTED : " + errorCode + " " + message);
					}

					@Override
					public void errored(ErrorCode errorCode, String message) {
						System.err.println("CLASS ERRORED : " + errorCode + " " + message);
					}

					@Override
					public void joinGame(String joinSecret) {
						System.err.println("CLASS JOIN GAME : " + joinSecret);
					}

					@Override
					public void joinRequest(DiscordJoinRequest joinRequest) {
						System.err.println("CLASS JOIN REQUEST : " + joinRequest);
					}

					@Override
					public void ready() {
						// System.err.println("CLASS READY");
					}

					@Override
					public void spectateGame(String spectateSecret) {
						System.err.println("CLASS SPECTATE GAME : " + spectateSecret);
					}
				};

				try {
					discordRpc.init(applicationId, discordEventHandler, true, null);

					Thread.sleep(5000L);
					discordRpc.runCallbacks();

					DiscordRichPresence discordRichPresence = new DiscordRichPresence();
					if (Hooks.client.isLoggedIn()) {
						if (!loggedIn) {
							start = System.currentTimeMillis() / 1000L;
							loggedIn = true;
						}
						discordRichPresence.setState("Logged In");
					} else {
						if (loggedIn) {
							start = System.currentTimeMillis() / 1000L;
							loggedIn = false;
						}
						discordRichPresence.setState("Logged Out");
					}

					discordRichPresence.setDetails(discordStatus);
					discordRichPresence.setStartTimestamp(start);
					// discordRichPresence.setEndTimestamp(end);
					// discordRichPresence.sett
					discordRichPresence.setLargeImageKey("defaultlarge");
					// discordRichPresence.setSmallImageKey("icon-small");
					// discordRichPresence.setPartyId("ALONE");
					// discordRichPresence.setPartySize(40);
					// discordRichPresence.setPartyMax(70);
					// discordRichPresence.setMatchSecret("hello");
					// discordRichPresence.setJoinSecret("join");
					// discordRichPresence.setSpectateSecret("look");
					discordRichPresence.setInstance(false);

					discordRpc.updatePresence(discordRichPresence);

					Thread.sleep(5000L);

					discordRpc.runCallbacks();
					discordRpc.shutdown();
					// Thread.sleep(5000L);

				} catch (InterruptedException ignored) {
				} finally {
					discordRpc.shutdown();
				}
			}

		}
	});

	public static void run() {
		t.start();
	}
}