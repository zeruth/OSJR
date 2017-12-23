package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class Class94 extends GameClass{
	
	public static final String playerIndexesCount = "playerIndexesCount";
	public static final String playerIndices = "playerIndices";
	public static final String Players_regions = "Players_regions";
	public static final String Players_orientations = "Players_orientations";
	public static final String Players_targetIndices = "Players_targetIndices";

	public Class94() {
		super(Hooks.classNames.get("class94"));
	}

	public int getPlayerIndexesCount() {
		return (int) fields.get(playerIndexesCount).getValue(reference);
	}
	
	public int[] getPlayerIndices() {
		return (int[]) fields.get(playerIndexesCount).getValue(reference);
	}
	
	public int[] getPlayers_regions() {
		return (int[]) fields.get(Players_regions).getValue(reference);
	}
	
	public int[] getPlayers_orientations() {
		return (int[]) fields.get(Players_orientations).getValue(reference);
	}
	
	public int[] getPlayers_targetIndices() {
		return (int[]) fields.get(Players_targetIndices).getValue(reference);
	}
}