package hooks.helpers;

import hooks.Hooks;

public class Skill {
	
	public static double getLevelUpPercentage(int skillID) {
		int xpForNextLevel = getXpForNextLevel(Hooks.client.getRealSkillLevels()[skillID]);
		int xpForCurrentLevel = getXpForNextLevel(Hooks.client.getRealSkillLevels()[skillID]-1);
		int currentXp = Hooks.client.getExperiences()[skillID];
		float percentage = ((float)(currentXp-xpForCurrentLevel) / (float)(xpForNextLevel-xpForCurrentLevel))*100;
		return roundDown5(percentage);
		
	}
	
	public static int getXpForNextLevel(int currentLevel) {
		switch (currentLevel) {
		case 1:
			return 83;
		case 2:
			return 174;
		case 3:
			return 276;
		case 4:
			return 388;
		case 5:
			return 512;
		case 6:
			return 650;
		case 7:
			return 801;
		case 8:
			return 969;
		case 9:
			return 1154;
		case 10:
			return 1358;
		case 11:
			return 1584;
		case 12:
			return 1833;
		case 13:
			return 2107;
		case 14:
			return 2411;
		case 15:
			return 2746;
		case 16:
			return 3115;
		case 17:
			return 3523;
		case 18:
			return 3973;
		case 19:
			return 4470;
		case 20:
			return 5018;
		case 21:
			return 5624;
		case 22:
			return 6291;
		case 23:
			return 7028;
		case 24:
			return 7842;
		case 25:
			return 8740;
		case 26:
			return 9730;
		case 27:
			return 10824;
		case 28:
			return 12031;
		case 29:
			return 13363;
		case 30:
			return 14833;
		case 31:
			return 16465;
		case 32:
			return 18247;
		case 33:
			return 20224;
		case 34:
			return 22406;
		case 35:
			return 24815;
		case 36:
			return 27473;
		case 37:
			return 30408;
		case 38:
			return 33648;
		case 39:
			return 37224;
		case 40:
			return 41171;
		case 41:
			return 45529;
		case 42:
			return 50339;
		case 43:
			return 55649;
		case 44:
			return 61512;
		case 45:
			return 67983;
		case 46:
			return 75127;
		case 47:
			return 83014;
		case 48:
			return 91721;
		case 49:
			return 101333;
		case 50:
			return 111945;
		case 51:
			return 123660;
		case 52:
			return 136594;
		case 53:
			return 150872;
		case 54:
			return 166636;
		case 55:
			return 184040;
		case 56:
			return 203254;
		case 57:
			return 224466;
		case 58:
			return 247886;
		case 59:
			return 273742;
			
			
		}
		return -1;
	}
	
	public static double roundDown5(double d) {
	    return (long) (d * 1e5) / 1e5;
	}
}
