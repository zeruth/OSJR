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
import os.jr.ui.Updater;

public class Utils {

	public static int size;
	private static int[] XPforLevel = new int[128];
	
	public static int localGamePackSize() {
		File file = new File(System.getProperty("user.home") + "/OSJR/gamepack.jar");
		return (int) file.length();
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
		}
	}
	

	public static String getUTCTime() {
		LocalDateTime ldt1 = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
		String second = ""+ldt1.getSecond();
		String minute= ""+ldt1.getMinute();
		String hour = ""+ldt1.getHour();

		if (Integer.valueOf(second)<10) {
			second = "0"+second;
		}
		if (Integer.valueOf(minute)<10) {
			minute = "0"+minute;
		}
		if (Integer.valueOf(hour)<10) {
			hour = "0"+hour;
		}
		return hour+":"+minute+":"+second+" UTC";
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

	public static int getXPforNextLevel(int currentLevel) {
		return XPforLevel[currentLevel + 1];
	}

	public static int getXPforCurrentLevel(int currentLevel) {
		return XPforLevel[currentLevel];
	}

}
