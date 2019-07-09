package org.doubt.tanner;

import org.osbot.rs07.api.map.Area;

public enum Location {
	AL_KHARID(
		new Area(3269, 3170, 3271, 3164),
		new Area(3277, 3189, 3272, 3194),
		"Ellis",
		"Al Kharid"
	);

	private Area bankArea = new Area(0, 0, 0, 0);
	private Area tanArea = new Area(0, 0, 0, 0);
	private String tannerName = "n/a";
	private String areaName = "n/a";

	Location(Area bankArea, Area tanArea, String tannerName, String areaName) {
		this.bankArea = bankArea;
		this.tanArea = tanArea;
		this.tannerName = tannerName;
		this.areaName = areaName;
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
}