package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class BuildType extends RSClass {

	public static final String RC = "RC";
	public static final String WIP = "WIP";
	public static final String LIVE = "LIVE";
	public static final String BUILD_LIVE = "RC";
	public static final String identifier = "identifier";
	public static final String ordinal = "ordinal";

	public BuildType() {
		super(Hooks.classNames.get("BuildType"));
	}

	public Object getBUILD_LIVE() {
		return getField(BUILD_LIVE).getValue(reference);
	}

	public String getIdentifier() {
		return (String) getField(identifier).getValue(reference);
	}

	public Object getLIVE() {
		return getField(LIVE).getValue(reference);
	}

	public int getOrdinal() {
		return (int) getField(ordinal).getValue(reference);
	}

	public Object getRC() {
		return getField(RC).getValue(reference);
	}

	public Object getWIP() {
		return getField(WIP).getValue(reference);
	}
}
