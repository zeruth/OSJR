package os.jr.game;

import os.jr.hooks.Client;
import os.jr.hooks.Hooks;
import os.jr.ui.StatMonitor;
import os.jr.utils.Utils;

public class Skill {
	static Client c;
	public static int[] currentXPs;
	public static int[] lastXPs = new int[25];
	

	public static final int ATTACK = 0, 
			DEFENCE = 1, 
			STRENGTH = 2,
			HITPOINTS = 3,
			RANGED = 4,
			PRAYER = 5,
			MAGIC = 6,
			COOKING = 7,
			WOODCUTTING = 8,
			FLETCHING = 9,
			FISHING = 10,
			FIREMAKING = 11,
			CRAFTING = 12,
			SMITHING = 13,
			MINING = 14,
			HERBLORE = 15,
			AGILITY = 16,
			THIEVING = 17,
			SLAYER = 18,
			FARMING = 19,
			RUNECRAFTING = 20,
			HUNTER = 21,
			CONSTRUCTION = 22;
	
	public static String getNameForID(int i) {
		if (i==ATTACK) {
			return "Attack";
		} else if (i == DEFENCE) {
			return "Defence";
		}else if (i == STRENGTH) {
			return "Strength";
		}else if (i == HITPOINTS) {
			return "Hitpoints";
		}else if (i == RANGED) {
			return "Ranged";
		}else if (i == PRAYER) {
			return "Prayer";
		}else if (i == MAGIC) {
			return "Magic";
		}else if (i == COOKING) {
			return "Cooking";
		}else if (i == WOODCUTTING) {
			return "Woodcutting";
		}else if (i == FLETCHING) {
			return "Fletching";
		}else if (i == FISHING) {
			return "Fishing";
		}else if (i == FIREMAKING) {
			return "Firemaking";
		}else if (i == CRAFTING) {
			return "Crafting";
		}else if (i == SMITHING) {
			return "Smithing";
		}else if (i == MINING) {
			return "Mining";
		}else if (i == HERBLORE) {
			return "Herblore";
		}else if (i == AGILITY) {
			return "Agility";
		}else if (i == THIEVING) {
			return "Thieving";
		}else if (i == SLAYER) {
			return "Slayer";
		}else if (i == FARMING) {
			return "Farming";
		}else if (i == RUNECRAFTING) {
			return "Runecrafting";
		}else if (i == HUNTER) {
			return "Hunter";
		}else if (i == CONSTRUCTION) {
			return "Construction";
		}
		return null;
	}
	
	public static void updateStatMonitor() {
		c = Hooks.selector.client;
		StatMonitor frame = StatMonitor.frame;
		frame.getAttackLevel().setText(""+c.getRealLevels()[Skill.ATTACK]);
		frame.getHitpointsLevel().setText(""+c.getRealLevels()[Skill.HITPOINTS]);
		frame.getMiningLevel().setText(""+c.getRealLevels()[Skill.MINING]);
		frame.getStrengthLevel().setText(""+c.getRealLevels()[Skill.STRENGTH]);
		frame.getAgilityLevel().setText(""+c.getRealLevels()[Skill.AGILITY]);
		frame.getSmithingLevel().setText(""+c.getRealLevels()[Skill.SMITHING]);
		frame.getDefenceLevel().setText(""+c.getRealLevels()[Skill.DEFENCE]);
		frame.getHerbloreLevel().setText(""+c.getRealLevels()[Skill.HERBLORE]);
		frame.getFishingLevel().setText(""+c.getRealLevels()[Skill.FISHING]);
		frame.getRangedLevel().setText(""+c.getRealLevels()[Skill.RANGED]);
		frame.getThievingLevel().setText(""+c.getRealLevels()[Skill.THIEVING]);
		frame.getCookingLevel().setText(""+c.getRealLevels()[Skill.COOKING]);
		frame.getPrayerLevel().setText(""+c.getRealLevels()[Skill.PRAYER]);
		frame.getCraftingLevel().setText(""+c.getRealLevels()[Skill.CRAFTING]);
		frame.getFiremakingLevel().setText(""+c.getRealLevels()[Skill.FIREMAKING]);
		frame.getMagicLevel().setText(""+c.getRealLevels()[Skill.MAGIC]);
		frame.getFletchingLevel().setText(""+c.getRealLevels()[Skill.FLETCHING]);
		frame.getWoodcuttingLevel().setText(""+c.getRealLevels()[Skill.WOODCUTTING]);
		frame.getRunecraftingLevel().setText(""+c.getRealLevels()[Skill.RUNECRAFTING]);
		frame.getSlayerLevel().setText(""+c.getRealLevels()[Skill.SLAYER]);
		frame.getFarmingLevel().setText(""+c.getRealLevels()[Skill.FARMING]);
		frame.getConstructionLevel().setText(""+c.getRealLevels()[Skill.CONSTRUCTION]);
		frame.getHunterLevel().setText(""+c.getRealLevels()[Skill.HUNTER]);
		
		frame.getAttackProgress().setValue(progressToNextLevel(Skill.ATTACK));
		frame.getHitpointsProgress().setValue(progressToNextLevel(Skill.HITPOINTS));
		frame.getMiningProgress().setValue(progressToNextLevel(Skill.MINING));
		frame.getStrengthProgress().setValue(progressToNextLevel(Skill.STRENGTH));
		frame.getAgilityProgress().setValue(progressToNextLevel(Skill.AGILITY));
		frame.getSmithingProgress().setValue(progressToNextLevel(Skill.SMITHING));
		frame.getDefenceProgress().setValue(progressToNextLevel(Skill.DEFENCE));
		frame.getHerbloreProgress().setValue(progressToNextLevel(Skill.HERBLORE));
		frame.getFishingProgress().setValue(progressToNextLevel(Skill.FISHING));
		frame.getRangedProgress().setValue(progressToNextLevel(Skill.RANGED));
		frame.getThievingProgress().setValue(progressToNextLevel(Skill.THIEVING));
		frame.getCookingProgress().setValue(progressToNextLevel(Skill.COOKING));
		frame.getPrayerProgress().setValue(progressToNextLevel(Skill.PRAYER));
		frame.getCraftingProgress().setValue(progressToNextLevel(Skill.CRAFTING));
		frame.getFiremakingProgress().setValue(progressToNextLevel(Skill.FIREMAKING));
		frame.getMagicProgress().setValue(progressToNextLevel(Skill.MAGIC));
		frame.getFletchingProgress().setValue(progressToNextLevel(Skill.FLETCHING));
		frame.getWoodcuttingProgress().setValue(progressToNextLevel(Skill.WOODCUTTING));
		frame.getRunecraftingProgress().setValue(progressToNextLevel(Skill.RUNECRAFTING));
		frame.getSlayerProgress().setValue(progressToNextLevel(Skill.SLAYER));
		frame.getFarmingProgress().setValue(progressToNextLevel(Skill.FARMING));
		frame.getConstructionProgress().setValue(progressToNextLevel(Skill.CONSTRUCTION));
		frame.getHunterProgress().setValue(progressToNextLevel(Skill.HUNTER));
		
		int totalLevels = 0;
		for (int i : c.getRealLevels()) {
			totalLevels+=i;
		}
		
		frame.getTotalLevelLabel().setText("Total: " + (totalLevels - 2));
	}
	
	public static int progressToNextLevel(int skill) {
		int currentlevelXP = Utils.getXPforCurrentLevel(c.realLevels[skill]);
		int nextlevelXP = Utils.getXPforNextLevel(c.realLevels[skill]);
		int XPforLevel = nextlevelXP - currentlevelXP;
	

		if (XPforLevel>0) {
			return (int) (((double)(c.getExperiences()[skill] - currentlevelXP) / XPforLevel) * 100);
		}

		
		return 0;
	}
	
	public static int[] getProgressedSkills() {
		currentXPs = Hooks.selector.client.getExperiences();
		int progressedSkills[] = new int[] {-1,-1,-1,-1,-1
				-1,-1,-1,-1,-1,
				-1,-1,-1,-1,-1,
				-1,-1,-1,-1,-1,
				-1,-1,-1,-1,-1};
		int count = 0;
		int cycle = 0;
		
		while (cycle!=currentXPs.length) {
			if (currentXPs[cycle]>lastXPs[cycle]) {
				progressedSkills[count] = cycle;
				count++;
				int currentXP = currentXPs[cycle];
				lastXPs[cycle]=currentXP;
			}
			cycle++;
		}
		return progressedSkills;
	}
}
