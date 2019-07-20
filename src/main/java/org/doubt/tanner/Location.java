package org.doubt.tanner;

import org.osbot.rs07.api.map.Area;

public enum Location {
	AL_KHARID(
		new Area(3269, 3170, 3271, 3164),
		new Area(3277, 3189, 3272, 3194),
		"Ellis",
		"Al Kharid",
		"alkharid"
	);

	private Area bankArea = new Area(0, 0, 0, 0);
	private Area tanArea = new Area(0, 0, 0, 0);
	private String tannerName = "n/a";
	private String areaName = "n/a";
	private String cliName = "n/a";

	Location(Area bankArea, Area tanArea, String tannerName, String areaName, String cliName) {
		this.bankArea = bankArea;
		this.tanArea = tanArea;
		this.tannerName = tannerName;
		this.areaName = areaName;
		this.cliName = cliName;
	}

	@Override
	public String toString() {
		return getAreaName();
	}

	public Area getBankArea() {
		return bankArea;
	}

	public Area getTanArea() {
		return tanArea;
	}

	public String getTannerName() {
		return tannerName;
	}

	public String getAreaName() {
		return areaName;
	}

	public String getCliName() {
		return cliName;
	}

	public static Location fromCliName(String cliName) {
		for (Location loc : Location.values()) {
			if (loc.cliName.equalsIgnoreCase(cliName)) {
				return loc;
			}
		}

		return null;
	}
}