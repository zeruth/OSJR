package os.jr.hooks;

import os.jr.hooks.loader.GameClass;

public class BuildType extends GameClass {

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
		return Hooks.selector.buildType.fields.get(BUILD_LIVE).getValue(reference);
	}

	public String getIdentifier() {
		return (String) Hooks.selector.buildType.fields.get(identifier).getValue(reference);
	}

	public Object getLIVE() {
		return Hooks.selector.buildType.fields.get(LIVE).getValue(reference);
	}

	public int getOrdinal() {
		return (int) Hooks.selector.buildType.fields.get(ordinal).getValue(reference);
	}

	public Object getRC() {
		return Hooks.selector.buildType.fields.get(RC).getValue(reference);
	}

	public Object getWIP() {
		return Hooks.selector.buildType.fields.get(WIP).getValue(reference);
	}
}
