package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class94 extends RSClass{
	
	public static final String playerIndexesCount = "playerIndexesCount";
	public static final String playerIndices = "playerIndices";
	public static final String Players_regions = "Players_regions";
	public static final String Players_orientations = "Players_orientations";
	public static final String Players_targetIndices = "Players_targetIndices";

	public Class94() {
		super(Hooks.classNames.get("class94"));
	}

	public int getPlayerIndexesCount() {
		return (int) getField(playerIndexesCount).getValue(reference);
	}
	
	public int[] getPlayerIndices() {
		return (int[]) getField(playerIndexesCount).getValue(reference);
	}
	
	public int[] getPlayers_regions() {
		return (int[]) getField(Players_regions).getValue(reference);
	}
	
	public int[] getPlayers_orientations() {
		return (int[]) getField(Players_orientations).getValue(reference);
	}
	
	public int[] getPlayers_targetIndices() {
		return (int[]) getField(Players_targetIndices).getValue(reference);
	}
}