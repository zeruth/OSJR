package hooks.helpers;

import hooks.Hooks;

public class Skill {
	
	public static double getLevelUpPercentage(int skillID) {
		int xpForNextLevel = getXpForNextLevel(Hooks.client.getRealSkillLevels()[skillID]);
		int xpForCurrentLevel = getXpForNextLevel(Hooks.client.getRealSkillLevels()[skillID]-1);
		int currentXp = Hooks.client.getExperiences()[skillID];
		float percentage = ((float)(currentXp-xpForCurrentLevel) / (float)(xpForNextLevel-xpForCurrentLevel))*100;
		if (currentXp==0) {
			return 0;
		}
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
		case 60:
			return 302288;
		case 61:
			return 333804;
		case 62:
			return 368599;
		case 63:
			return 407015;
		case 64:
			return 449428;
		case 65:
			return 496254;
		case 66:
			return 547953;
		case 67:
			return 605032;
		case 68:
			return 668051;
		case 69:
			return 737627;
		case 70:
			return 814445;
		case 71:
			return 899257;
		case 72:
			return 992885;
		case 73:
			return 1096278;
		case 74:
			return 1210421;
		case 75:
			return 1336443;
		case 76:
			return 1475581;
		case 77:
			return 1629200;
		case 78:
			return 1798808;
		case 79:
			return 1986808;
		case 80:
			return 2192818;
		case 81:
			return 2421087;
		case 82:
			return 2673114;
		case 83:
			return 2951373;
		case 84:
			return 3258594;
		case 85:
			return 3597792;
		case 86:
			return 3972294;
		case 87:
			return 4385776;
		case 88:
			return 4842295;
		case 89:
			return 5346332;
		case 90:
			return 5902831;
		case 91:
			return 6517253;
		case 92:
			return 7195629;
		case 93:
			return 7944614;
		case 94:
			return 8771558;
		case 95:
			return 9684577;
		case 96:
			return 10692629;
		case 97:
			return 11805606;
		case 98:
			return 13034431;
			
			
			
		}
		return -1;
	}
	
	public static String getNameForID(int skillID) {
		switch (skillID) {
		case 0:
			return "Attack";
		case 1:
			return "Defence";
		case 2:
			return "Strength";
		case 3:
			return "Hitpoints";
		case 4:
			return "Ranged";
		case 5:
			return "Prayer";
		case 6:
			return "Magic";
		case 7:
			return "Cooking";
		case 8:
			return "Woodcutting";
		case 9:
			return "Fletching";
		case 10:
			return "Fishing";
		case 11:
			return "Firemaking";
		case 12:
			return "Crafting";
		case 13:
			return "Smithing";
		case 14:
			return "Mining";
		case 15:
			return "Herblore";
		case 16:
			return "Agility";
		case 17:
			return "Thieving";
		case 18:
			return "Slayer";
		case 19:
			return "Farming";
		case 20:
			return "Runecrafting";
		case 21:
			return "Hunter";
		case 22:
			return "Construction";
		}
		return null;
	}
	
	public static double roundDown5(double d) {
	    return (long) (d * 1e5) / 1e5;
	}
}
