package os.jr.game;

import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import os.jr.hooks.Client;
import os.jr.hooks.Hooks;
import os.jr.ui.IndividualSkillMonitor;
import os.jr.ui.SkillMonitor;
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
	
	public static int getIDForName(String name) {
		if (name.compareTo("Attack")==0) {
			return Skill.ATTACK;
		} else if (name.compareTo("Defence")==0) {
			return Skill.DEFENCE;
		} else if (name.compareTo("Strength")==0) {
			return Skill.STRENGTH;
		} else if (name.compareTo("Hitpoints")==0) {
			return Skill.HITPOINTS;
		} else if (name.compareTo("Ranged")==0) {
			return Skill.RANGED;
		} else if (name.compareTo("Prayer")==0) {
			return Skill.PRAYER;
		} else if (name.compareTo("Magic")==0) {
			return Skill.MAGIC;
		} else if (name.compareTo("Cooking")==0) {
			return Skill.COOKING;
		} else if (name.compareTo("Woodcutting")==0) {
			return Skill.WOODCUTTING;
		} else if (name.compareTo("Fletching")==0) {
			return Skill.FLETCHING;
		} else if (name.compareTo("Fishing")==0) {
			return Skill.FISHING;
		} else if (name.compareTo("Firemaking")==0) {
			return Skill.FIREMAKING;
		} else if (name.compareTo("Crafting")==0) {
			return Skill.CRAFTING;
		} else if (name.compareTo("Smithing")==0) {
			return Skill.SMITHING;
		} else if (name.compareTo("Mining")==0) {
			return Skill.MINING;
		} else if (name.compareTo("Herblore")==0) {
			return Skill.HERBLORE;
		} else if (name.compareTo("Agility")==0) {
			return Skill.AGILITY;
		} else if (name.compareTo("Thieving")==0) {
			return Skill.THIEVING;
		} else if (name.compareTo("Slayer")==0) {
			return Skill.SLAYER;
		} else if (name.compareTo("Farming")==0) {
			return Skill.FARMING;
		} else if (name.compareTo("Runecrafting")==0) {
			return Skill.RUNECRAFTING;
		} else if (name.compareTo("Hunter")==0) {
			return Skill.HUNTER;
		} else if (name.compareTo("Construction")==0) {
			return Skill.CONSTRUCTION;
		}
		return -1;
	}
	
	public static void updateStatMonitor() {
		c = Hooks.selector.client;
		SkillMonitor frame = SkillMonitor.frame;
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

	public static void updateIndividualSkillPanel(IndividualSkillMonitor sm) {
		c = Hooks.selector.client;
		JComboBox<String> jcb = sm.getSkillSelector();
		JLabel skillIcon = sm.getSkillImageLabel();
		JLabel skillLvl = sm.getLevellabel();
		JLabel xpTilLvl = sm.getXptillevellabel();
		JLabel xpTil99 = sm.getXptil99label();
		JLabel xpTil120 = sm.getXptil120label();
		JProgressBar lvlProgress = sm.getProgressBar();
		NumberFormat nf1 = NumberFormat.getInstance();
		
			ImageIcon image = new ImageIcon(Skill.class.getResource("/resources/"+(String)jcb.getSelectedItem()+"-icon.png"));
			skillIcon.setIcon(image);
			skillLvl.setText(""+nf1.format(c.getRealLevels()[getIDForName((String)jcb.getSelectedItem())]));
			xpTilLvl.setText(""+nf1.format(getXPTilLevel(getIDForName((String)jcb.getSelectedItem()))));
			xpTil99.setText(""+nf1.format(getXPTil99(getIDForName((String)jcb.getSelectedItem()))));
			xpTil120.setText(""+nf1.format(getXPTil120(getIDForName((String)jcb.getSelectedItem()))));
			lvlProgress.setEnabled(true);
			lvlProgress.setValue(progressToNextLevel(getIDForName((String)jcb.getSelectedItem())));
	}
	
	public static int getXPTilLevel(int skill) {
		int xpForNextLvl = Utils.getXPforNextLevel(c.realLevels[skill]);
		return xpForNextLvl - c.experiences[skill];
	}
	
	public static int getXPTil99(int skill) {
		int xpFor99 = Utils.getXPforCurrentLevel(99);
		int xpTil99 = xpFor99 - c.experiences[skill];
		if (xpTil99<1) {
			return 0;
		}
		return xpTil99;
	}
	
	public static int getXPTil120(int skill) {
		int xpFor120 = Utils.getXPforCurrentLevel(120);
		int xpTil120 = xpFor120 - c.experiences[skill];
		if (xpTil120<1) {
			return 0;
		}
		return xpTil120;
	}
	
}
